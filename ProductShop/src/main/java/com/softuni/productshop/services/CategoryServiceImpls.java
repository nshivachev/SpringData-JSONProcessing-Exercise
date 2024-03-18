package com.softuni.productshop.services;

import com.softuni.productshop.constants.Utils;
import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;
import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryXmlDto;
import com.softuni.productshop.domain.dtos.categories.xmlWrapper.CategoryProductSummaryWrapperXmlDto;
import com.softuni.productshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.CATEGORIES_OUTPUT_BY_PRODUCTS_JSON_PATH;
import static com.softuni.productshop.constants.Paths.CATEGORIES_OUTPUT_BY_PRODUCTS_XML_PATH;
import static com.softuni.productshop.constants.Utils.MODEL_MAPPER;
import static com.softuni.productshop.constants.Utils.writeXmlIntoFile;

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

        Utils.writeJsonIntoFile(categories, CATEGORIES_OUTPUT_BY_PRODUCTS_JSON_PATH);

        return categories;
    }

    @Override
    public CategoryProductSummaryWrapperXmlDto getCategorySummaryXml() throws JAXBException {
        CategoryProductSummaryWrapperXmlDto categories = new CategoryProductSummaryWrapperXmlDto(
                categoryRepository.getCategorySummary()
                        .stream()
                        .map(category -> MODEL_MAPPER.map(category, CategoryProductSummaryXmlDto.class))
                        .toList());

        writeXmlIntoFile(categories, CATEGORIES_OUTPUT_BY_PRODUCTS_XML_PATH);

        return categories;
    }
}
