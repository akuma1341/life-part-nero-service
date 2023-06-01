package com.example.lifepartneroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class LifePartNeroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifePartNeroServiceApplication.class, args);
    }

}
