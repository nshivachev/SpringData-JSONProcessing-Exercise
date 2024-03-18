package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.*;
import com.softuni.productshop.domain.dtos.users.xmlWrappers.UserWithSoldProductsWrapperXmlDto;
import com.softuni.productshop.domain.dtos.users.xmlWrappers.UserWithUserCountWithSoldProductsWrapperXmlDto;
import com.softuni.productshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.*;
import static com.softuni.productshop.constants.Utils.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserWithSellingProductsWithBuyerDto> findAllUsersBySellingProductsWithBuyer() throws IOException {
        List<UserWithSellingProductsWithBuyerDto> users = userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderByLastName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSellingProductsWithBuyerDto.class))
                .toList();

        writeJsonIntoFile(users, USERS_OUTPUT_WITH_SOLD_PRODUCTS_WITH_BUYER_JSON_PATH);

        return users;
    }

    @Override
    public UserWithSoldProductsWrapperXmlDto findAllUsersBySellingProductsWithBuyerXml() throws JAXBException {
        UserWithSoldProductsWrapperXmlDto users = new UserWithSoldProductsWrapperXmlDto(userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderByLastName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSoldProductsXmlDto.class))
                .toList());

        writeXmlIntoFile(users, USERS_OUTPUT_WITH_SOLD_PRODUCTS_WITH_BUYER_XML_PATH);

        return users;
    }

    @Override
    public UserWrapperDto findAllUsersBySellingProductsWithBuyerOrderByProductCount() throws IOException {
        List<UserWithSellingProductsDto> users = userRepository
                .findAllBySellingProductsOrderByProductCount()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSellingProductsDto.class))
                .sorted((u1, u2) -> {
                    if (u1.getSellingProducts().size() == u2.getSellingProducts().size()) {
                        return u1.getLastName().compareTo(u2.getLastName());
                    }

                    return u1.getSellingProducts().size() > u2.getSellingProducts().size() ? -1 : 1;
                })
                .toList();

        UserWrapperDto user = new UserWrapperDto((long) users.size(), users);

        writeJsonIntoFile(user, USERS_OUTPUT_WITH_SOLD_PRODUCTS_JSON_PATH);

        return user;
    }

    @Override
    public UserWithUserCountWithSoldProductsWrapperXmlDto findAllUsersBySellingProductsWithBuyerOrderByProductCountXml() throws IOException, JAXBException {
        UserWithUserCountWithSoldProductsWrapperXmlDto users = new UserWithUserCountWithSoldProductsWrapperXmlDto(userRepository
                .findAllBySellingProductsOrderByProductCount()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithAgeWithSoldProductsXmlDto.class))
                .map(UserWithAgeWithSoldProductsXmlDto::setSellingProductsCount)
                .sorted((u1, u2) -> {
                    int result = u2.getSellingProducts().getCount().compareTo(u1.getSellingProducts().getCount());

                    if (result == 0) {
                        return u1.getLastName().compareTo(u2.getLastName());
                    }

                    return result;
                })
                .toList());

        writeXmlIntoFile(users, USERS_OUTPUT_WITH_SOLD_PRODUCTS_XML_PATH);

        return users;
    }
}
