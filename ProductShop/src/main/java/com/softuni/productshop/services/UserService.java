package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsWithBuyerDto;
import com.softuni.productshop.domain.dtos.users.UserWrapperDto;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithSellingProductsWithBuyerDto> findAllUsersBySellingProductsWithBuyer() throws IOException;

    UserWrapperDto findAllUsersBySellingProductsWithBuyerOrderByProductCount() throws IOException;
}
