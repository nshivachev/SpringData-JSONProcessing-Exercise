package com.softuni.productshop.services;

import com.softuni.productshop.constants.Paths;
import com.softuni.productshop.domain.dtos.categories.CategoryDto;
import com.softuni.productshop.domain.dtos.products.ImportProductDto;
import com.softuni.productshop.domain.dtos.users.ImportUserDto;
import com.softuni.productshop.domain.entities.Category;
import com.softuni.productshop.domain.entities.Product;
import com.softuni.productshop.domain.entities.User;
import com.softuni.productshop.repositories.CategoryRepository;
import com.softuni.productshop.repositories.ProductRepository;
import com.softuni.productshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.softuni.productshop.constants.Paths.*;
import static com.softuni.productshop.constants.Utils.GSON;
import static com.softuni.productshop.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServicesImpl implements SeedService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SeedServicesImpl(UserRepository userRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(USERS_JSON_PATH.toFile());

        userRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, ImportUserDto[].class))
                        .map(userDto -> MODEL_MAPPER.map(userDto, User.class))
                        .collect(Collectors.toList()));

        fileReader.close();
    }

    @Override
    public void seedProducts() throws IOException {
        if (productRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        productRepository.saveAllAndFlush(Arrays.stream(GSON.fromJson(fileReader, ImportProductDto[].class))
                .map(productDto -> MODEL_MAPPER.map(productDto, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories)
                .toList());

        fileReader.close();
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(CATEGORIES_JSON_PATH.toFile());

        categoryRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, CategoryDto[].class))
                        .map(categoryDto -> MODEL_MAPPER.map(categoryDto, Category.class))
                        .collect(Collectors.toList()));

        fileReader.close();
    }

    private Product setRandomCategories(Product product) {
        final Random random = new Random();

        final long numberOfCategories = random.nextLong(this.categoryRepository.count());

        final Set<Category> categories = new HashSet<>();

        LongStream.range(0, numberOfCategories)
                .forEach(number ->
                        categories.add(categoryRepository.getRandomEntity().orElseThrow(NoSuchElementException::new)));

        product.setCategories(categories);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
            User buyer = userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

            while (buyer.equals(product.getSeller())) {
                buyer = userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }

            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomSeller(Product product) {
        final User seller = userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

        product.setSeller(seller);

        return product;
    }
}
