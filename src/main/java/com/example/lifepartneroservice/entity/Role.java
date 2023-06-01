package com.example.lifepartneroservice.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rol_id", nullable = false, length = 20)),
        @AttributeOverride(name = "dateAdded", column = @Column(name = "rol_date_added", columnDefinition = "DATETIME")),
        @AttributeOverride(name = "dateModified", column = @Column(name = "rol_date_modified", columnDefinition = "DATETIME"))
})
@SequenceGenerator(name = "default_gen", sequenceName = "roles_rol_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role extends AbstractEntity {

    @Column(name = "rol_name")
    private String name;

    @Column(name = "rol_enabled")
    private boolean enabled;
}
