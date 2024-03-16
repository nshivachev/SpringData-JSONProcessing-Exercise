package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsDto;
import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsWithBuyerDto;
import com.softuni.productshop.domain.dtos.users.UserWithSoldProductsXmlDto;
import com.softuni.productshop.domain.dtos.users.UserWrapperDto;
import com.softuni.productshop.domain.dtos.users.xmlWrappers.UserWithSoldProductsWrapperXmlDto;
import com.softuni.productshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.softuni.productshop.constants.Paths.*;
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
    public UserWithSoldProductsWrapperXmlDto findAllUsersBySellingProductsWithBuyerXml() throws IOException, JAXBException {
        UserWithSoldProductsWrapperXmlDto users = new UserWithSoldProductsWrapperXmlDto(userRepository
                .findAllBySellingProductsBuyerIsNotNullOrderByLastName()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSoldProductsXmlDto.class))
                .toList());

        final File file = USERS_OUTPUT_WITH_SOLD_PRODUCTS_WITH_BUYER_XML_PATH.toFile();

        final JAXBContext context = JAXBContext.newInstance(UserWithSoldProductsWrapperXmlDto.class);
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(users, file);

        return users;
    }

    @Override
    public UserWrapperDto findAllUsersBySellingProductsWithBuyerOrderByProductCount() throws IOException {
        List<UserWithSellingProductsDto> users = userRepository
                .findAllBySellingProductsOrderByProductCount()
                .stream()
                .map(user -> MODEL_MAPPER.map(user, UserWithSellingProductsDto.class))
                .toList();

        UserWrapperDto user = new UserWrapperDto((long) users.size(), users);

        writeJsonIntoFile(user, USERS_OUTPUT_WITH_SOLD_PRODUCTS_JSON_PATH);

        return user;
    }
}
