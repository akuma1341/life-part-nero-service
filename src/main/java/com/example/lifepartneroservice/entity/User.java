package com.example.lifepartneroservice.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "usr_id", nullable = false, length = 20)),
        @AttributeOverride(name = "dateAdded", column = @Column(name = "usr_date_added", columnDefinition = "DATETIME")),
        @AttributeOverride(name = "dateModified", column = @Column(name = "usr_date_modified", columnDefinition = "DATETIME"))
})
@SequenceGenerator(name = "default_gen", sequenceName = "users_usr_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends AbstractEntity {

    @Column(name = "usr_username")
    private String username;

    @Column(name = "usr_password")
    private String password;

    @Column(name = "usr_enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "urr_usr_id", referencedColumnName = "usr_id"),
                inverseJoinColumns = @JoinColumn(name = "urr_rol_id", referencedColumnName = "rol_id"))
    private Set<Role> roles;
}
