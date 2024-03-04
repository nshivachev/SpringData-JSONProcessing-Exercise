package com.softuni.productshop.services;

import com.softuni.productshop.repositories.CategoryRepository;
import com.softuni.productshop.repositories.ProductRepository;
import com.softuni.productshop.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SeedServicesImpl implements SeedService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SeedServicesImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedUsers() {

    }

    @Override
    public void seedProducts() {

    }

    @Override
    public void seedCategories() {

    }
}
