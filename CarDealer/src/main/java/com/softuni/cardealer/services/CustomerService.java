package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.customers.CustomerDto;
import com.softuni.cardealer.domains.dtos.customers.CustomerWrapperDto;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAllOrderByBirthDateThenOrderByYoungerDriver() throws IOException;

    List<CustomerWrapperDto> findAllBySalesIsNotEmpty() throws IOException;
}
