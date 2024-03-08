package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ImportProductDto;
import com.softuni.productshop.domain.dtos.products.ProductWithSellerDto;
import com.softuni.productshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.softuni.productshop.constants.Paths.PRODUCTS_WITH_NO_BUYER_IN_RANGE_JSON_PATH;
import static com.softuni.productshop.constants.Utils.writeJsonIntoFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductWithSellerDto> selectAllInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException {
        final List<ProductWithSellerDto> products = productRepository.findAllInPriceRangeBetween(startPrice, endPrice);

        writeJsonIntoFile(products, PRODUCTS_WITH_NO_BUYER_IN_RANGE_JSON_PATH);

        return products;
    }
}
