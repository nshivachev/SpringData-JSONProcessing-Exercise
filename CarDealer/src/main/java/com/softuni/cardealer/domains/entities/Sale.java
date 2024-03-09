package com.softuni.cardealer.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    @Basic
    private Double discount;

    @OneToOne
    private Car car;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(car, sale.car)
                && Objects.equals(customer, sale.customer)
                && Objects.equals(getId(), sale.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, customer, getId());
    }
}
