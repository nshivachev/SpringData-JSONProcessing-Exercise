package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceSellerDto;
import com.softuni.productshop.domain.dtos.products.xmlWrappers.ProductWithNamePriceSellerWrapperXmlDto;
import com.softuni.productshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.softuni.productshop.constants.Paths.PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_JSON_PATH;
import static com.softuni.productshop.constants.Paths.PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_XML_PATH;
import static com.softuni.productshop.constants.Utils.writeJsonIntoFile;
import static com.softuni.productshop.constants.Utils.writeXmlIntoFile;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductWithNamePriceSellerDto> selectAllProductsInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException {
        final List<ProductWithNamePriceSellerDto> products = productRepository.findAllInPriceRangeBetween(startPrice, endPrice);

        writeJsonIntoFile(products, PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_JSON_PATH);

        return products;
    }

    @Override
    @Transactional
    public ProductWithNamePriceSellerWrapperXmlDto selectAllProductsInPriceRangeXml(BigDecimal startPrice, BigDecimal endPrice) throws JAXBException {
        final ProductWithNamePriceSellerWrapperXmlDto products =
                new ProductWithNamePriceSellerWrapperXmlDto(productRepository.findAllInPriceRangeBetweenXml(startPrice, endPrice));

        writeXmlIntoFile(products, PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_XML_PATH);

        return products;
    }
}
