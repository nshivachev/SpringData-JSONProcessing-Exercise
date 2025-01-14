package com.softuni.cardealer.domains.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Objects;

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
    private int quantity;

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
