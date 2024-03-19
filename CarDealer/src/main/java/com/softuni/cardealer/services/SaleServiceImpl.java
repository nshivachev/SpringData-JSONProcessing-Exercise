package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.sales.SaleWithDiscountAndCarAndCustomerDto;
import com.softuni.cardealer.domains.dtos.sales.SaleWrapperDto;
import com.softuni.cardealer.domains.dtos.sales.xmlWrappers.SaleWithPriceAndDiscountWrapperXmlDto;
import com.softuni.cardealer.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.SALES_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Paths.SALES_OUTPUT_XML_PATH;
import static com.softuni.cardealer.constants.Utils.*;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    @Override
    public List<SaleWrapperDto> findAllWithCarCustomerPrice() throws IOException {
        List<SaleWrapperDto> sales = saleRepository.findAll()
                .stream()
                .map(sale -> MODEL_MAPPER.map(sale, SaleWithDiscountAndCarAndCustomerDto.class))
                .map(SaleWithDiscountAndCarAndCustomerDto::toSaleWrapperDto)
                .toList();

        writeJsonIntoFile(sales, SALES_OUTPUT_JSON_PATH);

        return sales;
    }

    @Override
    public SaleWithPriceAndDiscountWrapperXmlDto findAllWithCarCustomerPriceXml() throws JAXBException {
        SaleWithPriceAndDiscountWrapperXmlDto sales = new SaleWithPriceAndDiscountWrapperXmlDto(
                saleRepository.findAll()
                .stream()
                .map(sale -> MODEL_MAPPER.map(sale, SaleWithDiscountAndCarAndCustomerDto.class))
                .map(SaleWithDiscountAndCarAndCustomerDto::toSaleWithPriceAndDiscountXmlDto)
                .toList());

        writeXmlIntoFile(sales, SALES_OUTPUT_XML_PATH);

        return sales;
    }
}
