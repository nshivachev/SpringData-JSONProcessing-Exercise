package com.softuni.productshop.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path USERS_INPUT_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "json", "users.json");
    public final static Path CATEGORIES_INPUT_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "json", "categories.json");
    public final static Path PRODUCTS_INPUT_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "json", "products.json");

    public final static Path PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "json", "products-in-range.json");
    public final static Path USERS_OUTPUT_WITH_SOLD_PRODUCTS_WITH_BUYER_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "json", "users-sold-products_buyer.json");
    public final static Path CATEGORIES_OUTPUT_BY_PRODUCTS_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "json", "categories-by-products.json");
    public final static Path USERS_OUTPUT_WITH_SOLD_PRODUCTS_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "json", "users-sold-products.json");

    public final static Path USERS_INPUT_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "xml", "users.xml");
    public final static Path CATEGORIES_INPUT_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "xml", "categories.xml");
    public final static Path PRODUCTS_INPUT_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "xml", "products.xml");

    public final static Path PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "xml", "products-in-range.xml");
    public final static Path USERS_OUTPUT_WITH_SOLD_PRODUCTS_WITH_BUYER_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "xml", "users-sold-products_buyer.xml");
    public final static Path CATEGORIES_OUTPUT_BY_PRODUCTS_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "xml", "categories-by-products.xml");
    public final static Path USERS_OUTPUT_WITH_SOLD_PRODUCTS_XML_PATH = Path.of("ProductShop", "src", "main", "resources", "outputs", "xml", "users-sold-products.xml");
}
