package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.customers.CustomerDto;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllOrderByBirthDate() throws IOException;
}
