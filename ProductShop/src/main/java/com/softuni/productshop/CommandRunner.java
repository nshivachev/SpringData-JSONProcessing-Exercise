package com.softuni.productshop;

import com.softuni.productshop.services.CategoryService;
import com.softuni.productshop.services.ProductService;
import com.softuni.productshop.services.SeedService;
import com.softuni.productshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public CommandRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();

        productService.selectAllProductsInPriceRange(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        userService.findAllUsersBySellingProductsWithBuyer();
        categoryService.getCategorySummary();
        userService.findAllUsersBySellingProductsWithBuyerOrderByProductCount();

        productService.selectAllProductsInPriceRangeXml(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        userService.findAllUsersBySellingProductsWithBuyerXml();
        categoryService.getCategorySummaryXml();
    }
}
