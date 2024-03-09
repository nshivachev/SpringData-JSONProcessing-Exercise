package com.softuni.cardealer.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    @Basic
    private String name;

    @Basic
    private BigDecimal price;

    @Basic
    private Integer quantity;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Car> cars;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Supplier supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(name, part.name)
                && Objects.equals(quantity, part.quantity)
                && Objects.equals(getId(), part.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, getId());
    }
}
