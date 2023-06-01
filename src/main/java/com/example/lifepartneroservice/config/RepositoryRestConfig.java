package com.example.lifepartneroservice.config;

import com.example.lifepartneroservice.json.JsonLocalDateDeserializer;
import com.example.lifepartneroservice.json.JsonLocalDateSerializer;
import com.example.lifepartneroservice.json.JsonLocalDateTimeDeserializer;
import com.example.lifepartneroservice.json.JsonLocalDateTimeSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED;

@Configuration
@RequiredArgsConstructor
public class RepositoryRestConfig implements RepositoryRestConfigurer {

    private final Validator jsr303Validator;

    @Value("${spring.data.rest.base-path}")
    private String restBasePath;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.setRepositoryDetectionStrategy(ANNOTATED);
        config.setReturnBodyForPutAndPost(true);
        config.setBasePath(restBasePath);
    }

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        var module = new SimpleModule("LocalDateModule");
        module.addSerializer(LocalDate.class, new JsonLocalDateSerializer());
        module.addDeserializer(LocalDate.class, new JsonLocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new JsonLocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new JsonLocalDateTimeDeserializer());
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeCreate", jsr303Validator);
        validatingListener.addValidator("beforeSave", jsr303Validator);
    }

}
