package com.softuni.cardealer.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path CARS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "json", "cars.json");
    public final static Path CUSTOMERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "json", "customers.json");
    public final static Path PARTS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "json", "parts.json");
    public final static Path SUPPLIERS_INPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "json", "suppliers.json");

    public final static Path CUSTOMERS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "customers.json");
    public final static Path CUSTOMERS_WITH_CAR_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "customers-with-car.json");
    public final static Path CARS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "cars.json");
    public final static Path CARS_PARTS_NAME_PRICE_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "cas-parts-name-price.json");
    public final static Path SUPPLIERS_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "suppliers.json");
    public final static Path SALES_OUTPUT_JSON_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "json", "sales.json");

    public final static Path CARS_INPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "xml", "cars.xml");
    public final static Path CUSTOMERS_INPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "xml", "customers.xml");
    public final static Path PARTS_INPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "xml", "parts.xml");
    public final static Path SUPPLIERS_INPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "dbContent", "xml", "suppliers.xml");

    public final static Path CUSTOMERS_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "customers.xml");
    public final static Path CUSTOMERS_WITH_CAR_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "customers-with-car.xml");
    public final static Path CARS_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "cars.xml");
    public final static Path CARS_PARTS_NAME_PRICE_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "cas-parts-name-price.xml");
    public final static Path SUPPLIERS_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "suppliers.xml");
    public final static Path SALES_OUTPUT_XML_PATH = Path.of("CarDealer", "src", "main", "resources", "outputs", "xml", "sales.xml");
}
