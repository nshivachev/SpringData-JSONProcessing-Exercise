package com.softuni.productshop.constants;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path USERS_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "users.json");
    public final static Path CATEGORIES_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "categories.json");
    public final static Path PRODUCTS_JSON_PATH = Path.of("ProductShop", "src", "main", "resources", "dbContent", "products.json");
    public final static Path PRODUCTS_WITH_NO_BUYER_IN_RANGE = Path.of("ProductShop", "src", "main", "resources", "outputs", "products-in-range.json");
}
