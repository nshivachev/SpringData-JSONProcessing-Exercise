package com.softuni.productshop.services;

import com.softuni.productshop.constants.Utils;
import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;
import com.softuni.productshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.CATEGORIES_BY_PRODUCTS_JSON_PATH;

@Service
public class CategoryServiceImpls implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpls(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryProductSummaryDto> getCategorySummary() throws IOException {
        List<CategoryProductSummaryDto> categories = categoryRepository.getCategorySummary();

        Utils.writeJsonIntoFile(categories, CATEGORIES_BY_PRODUCTS_JSON_PATH);

        return categories;
    }
}
