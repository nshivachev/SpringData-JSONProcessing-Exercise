package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceSellerDto;
import com.softuni.productshop.domain.dtos.products.xmlWrappers.ProductWithNamePriceSellerWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductWithNamePriceSellerDto> selectAllProductsInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException, JAXBException;

    ProductWithNamePriceSellerWrapperXmlDto selectAllProductsInPriceRangeXml(BigDecimal startPrice, BigDecimal endPrice) throws JAXBException;
}
