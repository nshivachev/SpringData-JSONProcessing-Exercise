package com.softuni.productshop.services;

import com.softuni.productshop.constants.Utils;
import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;
import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryXmlDto;
import com.softuni.productshop.domain.dtos.categories.xmlWrapper.CategoryProductSummaryWrapperXmlDto;
import com.softuni.productshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.CATEGORIES_OUTPUT_BY_PRODUCTS_JSON_PATH;
import static com.softuni.productshop.constants.Paths.CATEGORIES_OUTPUT_BY_PRODUCTS_XML_PATH;
import static com.softuni.productshop.constants.Utils.MODEL_MAPPER;

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

        final File file = CATEGORIES_OUTPUT_BY_PRODUCTS_XML_PATH.toFile();

        final JAXBContext context = JAXBContext.newInstance(CategoryProductSummaryWrapperXmlDto.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(categories, file);

        return categories;
    }
}
