package com.softuni.productshop.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    @Min(3)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User buyer;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User seller;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    Set<Category> categories;
}
