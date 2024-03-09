package com.softuni.cardealer.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path CARS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "cars.json");
    public final static Path CUSTOMERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "customers.json");
    public final static Path PARTS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "parts.json");
    public final static Path SUPPLIERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "suppliers.json");
}
