package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsDto;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithSellingProductsDto> findAllBySellingProductsBuyerNotNull() throws IOException;
}
