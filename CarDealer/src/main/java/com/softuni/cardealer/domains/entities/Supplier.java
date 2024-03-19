package com.softuni.cardealer.domains.entities;

import com.softuni.cardealer.domains.dtos.suppliers.SupplierWithNameAndPartsCountDto;
import com.softuni.cardealer.domains.dtos.suppliers.SupplierWithNameAndPartsCountXmlDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {
    @Basic
    private String name;

    @Column(name = "is_importer")
    private boolean isImporter;

    @OneToMany(targetEntity = Part.class, mappedBy = "supplier")
    @Fetch(FetchMode.JOIN)
    private Set<Part> parts;

    public SupplierWithNameAndPartsCountDto toSupplierWithNamePartsCountDto() {
        return new SupplierWithNameAndPartsCountDto(getId(), name, parts.size());
    }

    public SupplierWithNameAndPartsCountXmlDto toSupplierWithNamePartsCountXmlDto() {
        return new SupplierWithNameAndPartsCountXmlDto(getId(), name, parts.size());
    }
}
