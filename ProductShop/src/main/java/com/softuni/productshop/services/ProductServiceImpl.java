package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductPriceNameSellerDto;
import com.softuni.productshop.domain.dtos.products.ProductWithNoBuyerDto;
import com.softuni.productshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.softuni.productshop.constants.Paths.PRODUCTS_WITH_NO_BUYER_IN_RANGE;
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
    public List<ProductWithNoBuyerDto> selectAllInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException {
        final List<ProductWithNoBuyerDto> products = productRepository.findAllInPriceRangeBetween(startPrice, endPrice).stream().map(ProductPriceNameSellerDto::toProductWithNoBuyerDto).toList();

        writeJsonIntoFile(products, PRODUCTS_WITH_NO_BUYER_IN_RANGE);

        return products;
    }
}
