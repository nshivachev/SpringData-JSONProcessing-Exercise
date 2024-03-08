package com.softuni.productshop;

import com.softuni.productshop.services.ProductService;
import com.softuni.productshop.services.SeedService;
import com.softuni.productshop.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CommandRunner(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedService.seedAll();

        productService.selectAllInPriceRange(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));
        userService.findAllBySellingProductsBuyerNotNull();
    }
}
