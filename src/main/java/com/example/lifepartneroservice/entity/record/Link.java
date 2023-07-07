package com.example.lifepartneroservice.entity.record;

import com.example.lifepartneroservice.entity.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "links")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "link_id", nullable = false, length = 20)),
        @AttributeOverride(name = "dateAdded", column = @Column(name = "link_date_added", columnDefinition = "DATETIME")),
        @AttributeOverride(name = "dateModified", column = @Column(name = "link_date_modified", columnDefinition = "DATETIME"))
})
@SequenceGenerator(name = "default_gen", sequenceName = "links_link_id_seq", allocationSize = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Link extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "link_id")
    @MapsId
    private Record record;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "links_relations",
            joinColumns = @JoinColumn(name = "parent_link_id", referencedColumnName = "link_id"),
            inverseJoinColumns = @JoinColumn(name = "child_link_id", referencedColumnName = "link_id"))
    private Set<Link> parents;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "links_relations",
            joinColumns = @JoinColumn(name = "child_link_id", referencedColumnName = "link_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_link_id", referencedColumnName = "link_id"))
    private Set<Link> children;

}
