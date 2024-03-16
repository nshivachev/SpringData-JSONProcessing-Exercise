package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;
import com.softuni.productshop.domain.dtos.categories.xmlWrapper.CategoryProductSummaryWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryProductSummaryDto> getCategorySummary() throws IOException;

    CategoryProductSummaryWrapperXmlDto getCategorySummaryXml() throws JAXBException;
}
