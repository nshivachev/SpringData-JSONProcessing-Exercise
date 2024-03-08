package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsDto;
import com.softuni.productshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.USERS_WITH_SOLD_PRODUCTS_JSON_PATH;
import static com.softuni.productshop.constants.Utils.MODEL_MAPPER;
import static com.softuni.productshop.constants.Utils.writeJsonIntoFile;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSellingProductsDto> findAllBySellingProductsBuyerNotNull() throws IOException {
        List<UserWithSellingProductsDto> users = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderByLastName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSellingProductsDto.class))
                .toList();

        writeJsonIntoFile(users, USERS_WITH_SOLD_PRODUCTS_JSON_PATH);

        return users;
    }
}
