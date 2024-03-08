package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductWithSellerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductWithSellerDto> selectAllInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException;
}
