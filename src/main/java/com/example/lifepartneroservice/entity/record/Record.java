package com.example.lifepartneroservice.entity.record;

import com.example.lifepartneroservice.entity.AbstractEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "records")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "rec_id", nullable = false, length = 20)),
        @AttributeOverride(name = "dateAdded", column = @Column(name = "rec_date_added", columnDefinition = "DATETIME")),
        @AttributeOverride(name = "dateModified", column = @Column(name = "rec_date_modified", columnDefinition = "DATETIME"))
})
@SequenceGenerator(name = "default_gen", sequenceName = "records_rec_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Record extends AbstractEntity {

    @Column(name = "rec_name")
    private String name;
}
