package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceSellerDto;
import com.softuni.productshop.domain.dtos.products.xmlWrappers.ProductWithNamePriceSellerWrapperXmlDto;
import com.softuni.productshop.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static com.softuni.productshop.constants.Paths.PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_JSON_PATH;
import static com.softuni.productshop.constants.Paths.PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_XML_PATH;
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
    public List<ProductWithNamePriceSellerDto> selectAllProductsInPriceRange(BigDecimal startPrice, BigDecimal endPrice) throws IOException, JAXBException {
        final List<ProductWithNamePriceSellerDto> products = productRepository.findAllInPriceRangeBetween(startPrice, endPrice);

        writeJsonIntoFile(products, PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_JSON_PATH);

        return products;
    }

    @Override
    @Transactional
    public ProductWithNamePriceSellerWrapperXmlDto selectAllProductsInPriceRangeXml(BigDecimal startPrice, BigDecimal endPrice) throws JAXBException {
        final ProductWithNamePriceSellerWrapperXmlDto products =
                new ProductWithNamePriceSellerWrapperXmlDto(productRepository.findAllInPriceRangeBetweenXml(startPrice, endPrice));

        final File file = PRODUCTS_OUTPUT_WITH_NO_BUYER_IN_RANGE_XML_PATH.toFile();

        final JAXBContext context = JAXBContext.newInstance(ProductWithNamePriceSellerWrapperXmlDto.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(products, file);

        return products;
    }
}
