package com.softuni.productshop.services;

public interface SeedService {
    void seedUsers();

    void seedProducts();

    void seedCategories();

    default void seedAll() {
        seedUsers();
        seedProducts();
        seedCategories();
    }
}
