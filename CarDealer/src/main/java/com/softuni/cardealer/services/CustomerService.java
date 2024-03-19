package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.customers.CustomerDto;
import com.softuni.cardealer.domains.dtos.customers.CustomerWrapperDto;
import com.softuni.cardealer.domains.dtos.customers.xmlWrappers.CustomerWithSpentMoneyWrapperXmlDto;
import com.softuni.cardealer.domains.dtos.customers.xmlWrappers.CustomerWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAllOrderByBirthDateThenOrderByYoungerDriver() throws IOException;

    CustomerWrapperXmlDto findAllOrderByBirthDateThenOrderByYoungerDriverXml() throws IOException, JAXBException;

    List<CustomerWrapperDto> findAllBySalesIsNotEmpty() throws IOException;

    CustomerWithSpentMoneyWrapperXmlDto findAllBySalesIsNotEmptyXml() throws JAXBException;
}
