package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryProductSummaryDto> getCategorySummary() throws IOException;
}
