package com.softuni.cardealer.services;

import java.io.IOException;

public interface SeedService {
    void seedSuppliers() throws IOException;

    void seedParts();

    void seedCars();

    void seedCustomers();

    void seedSales();

    default void seedAll() throws IOException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}
