package com.example.lifepartneroservice.entity.record;

import com.example.lifepartneroservice.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "tags")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "tag_id", nullable = false, length = 20)),
        @AttributeOverride(name = "dateAdded", column = @Column(name = "tag_date_added", columnDefinition = "DATETIME")),
        @AttributeOverride(name = "dateModified", column = @Column(name = "tag_date_modified", columnDefinition = "DATETIME"))
})
@SequenceGenerator(name = "default_gen", sequenceName = "tags_tag_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Tag extends AbstractEntity {

    @Column(name = "tag_name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Record> records;

}
