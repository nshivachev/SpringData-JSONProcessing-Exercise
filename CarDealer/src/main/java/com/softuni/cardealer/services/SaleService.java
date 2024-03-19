package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.sales.SaleWrapperDto;
import com.softuni.cardealer.domains.dtos.sales.xmlWrappers.SaleWithPriceAndDiscountWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface SaleService {
    List<SaleWrapperDto> findAllWithCarCustomerPrice() throws IOException;

    SaleWithPriceAndDiscountWrapperXmlDto findAllWithCarCustomerPriceXml() throws JAXBException;
}
