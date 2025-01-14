package com.softuni.cardealer.domains.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    @Basic
    private String make;

    @Basic
    private String model;

    @Column(name = "travelled_distance")
    private Long travelledDistance;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Part> parts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make)
                && Objects.equals(model, car.model)
                && Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, getId());
    }
}
