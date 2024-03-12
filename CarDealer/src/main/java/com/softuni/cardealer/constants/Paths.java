package com.softuni.cardealer.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path CARS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "cars.json");
    public final static Path CUSTOMERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "customers.json");
    public final static Path PARTS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "parts.json");
    public final static Path SUPPLIERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "suppliers.json");

    public final static Path CUSTOMERS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "customers.json");
    public final static Path CUSTOMERS_WITH_CAR_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "customers-with-car.json");
    public final static Path CARS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "cars.json");
    public final static Path CARS_PARTS_NAME_PRICE_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "cas-parts-name-price.json");
    public final static Path SUPPLIERS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "suppliers.json");
    public final static Path SALES_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "sales.json");
}
