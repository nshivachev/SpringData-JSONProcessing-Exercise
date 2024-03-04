package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
