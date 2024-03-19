package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.customers.*;
import com.softuni.cardealer.domains.dtos.customers.xmlWrappers.CustomerWithSpentMoneyWrapperXmlDto;
import com.softuni.cardealer.domains.dtos.customers.xmlWrappers.CustomerWrapperXmlDto;
import com.softuni.cardealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.*;
import static com.softuni.cardealer.constants.Utils.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> findAllOrderByBirthDateThenOrderByYoungerDriver() throws IOException {
        final List<CustomerDto> customers = customerRepository
                .findAllOrderByBirthDateThenOrderByYoungerDriver()
                .stream()
                .map(customer -> MODEL_MAPPER.map(customer, CustomerDto.class))
                .toList();

        writeJsonIntoFile(customers, CUSTOMERS_OUTPUT_JSON_PATH);

        return customers;
    }

    @Override
    public CustomerWrapperXmlDto findAllOrderByBirthDateThenOrderByYoungerDriverXml() throws IOException, JAXBException {
        final CustomerWrapperXmlDto customers = new CustomerWrapperXmlDto(customerRepository
                .findAllOrderByBirthDateThenOrderByYoungerDriver()
                .stream()
                .map(customer -> MODEL_MAPPER.map(customer, CustomerXmlDto.class))
                .toList());

        writeXmlIntoFile(customers, CUSTOMERS_OUTPUT_XML_PATH);

        return customers;
    }

    @Override
    public List<CustomerWrapperDto> findAllBySalesIsNotEmpty() throws IOException {
        List<CustomerWrapperDto> customers = customerRepository
                .findAllBySalesIsNotEmpty()
                .stream()
                .map(customer -> MODEL_MAPPER.map(customer, CustomerWithNameAndSalesDto.class))
                .map(CustomerWithNameAndSalesDto::toCustomerWrapperDto)
                .sorted(Comparator.comparing(CustomerWrapperDto::getSpentMoney).thenComparingLong(CustomerWrapperDto::getBoughtCars).reversed())
                .toList();

        writeJsonIntoFile(customers, CUSTOMERS_WITH_CAR_OUTPUT_JSON_PATH);

        return customers;
    }

    @Override
    public CustomerWithSpentMoneyWrapperXmlDto findAllBySalesIsNotEmptyXml() throws JAXBException {
        CustomerWithSpentMoneyWrapperXmlDto customers = new CustomerWithSpentMoneyWrapperXmlDto(
                customerRepository
                .findAllBySalesIsNotEmpty()
                .stream()
                .map(customer -> MODEL_MAPPER.map(customer, CustomerWithNameAndSalesDto.class))
                .map(CustomerWithNameAndSalesDto::toCustomerWithSpentMoneyXmlDto)
                .sorted(Comparator.comparing(CustomerWithSpentMoneyXmlDto::getSpentMoney).thenComparingLong(CustomerWithSpentMoneyXmlDto::getBoughtCars).reversed())
                .toList());

        writeXmlIntoFile(customers, CUSTOMERS_WITH_CAR_OUTPUT_XML_PATH);

        return customers;
    }
}
