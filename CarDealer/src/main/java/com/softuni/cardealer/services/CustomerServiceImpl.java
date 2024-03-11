package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.customers.CustomerDto;
import com.softuni.cardealer.domains.entities.Customer;
import com.softuni.cardealer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.CUSTOMERS_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Utils.MODEL_MAPPER;
import static com.softuni.cardealer.constants.Utils.writeJsonIntoFile;

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
    public List<Customer> findAllBySalesIsNotEmpty() {
        return customerRepository.findAllBySalesIsNotEmpty();
    }
}
