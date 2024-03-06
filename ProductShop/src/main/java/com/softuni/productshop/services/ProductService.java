package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductWithNoBuyerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductWithNoBuyerDto> selectAllInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException;
}
