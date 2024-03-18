package com.softuni.productshop.services;

import com.softuni.productshop.domain.dtos.users.UserWithSellingProductsWithBuyerDto;
import com.softuni.productshop.domain.dtos.users.UserWrapperDto;
import com.softuni.productshop.domain.dtos.users.xmlWrappers.UserWithSoldProductsWrapperXmlDto;
import com.softuni.productshop.domain.dtos.users.xmlWrappers.UserWithUserCountWithSoldProductsWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<UserWithSellingProductsWithBuyerDto> findAllUsersBySellingProductsWithBuyer() throws IOException;

    UserWithSoldProductsWrapperXmlDto findAllUsersBySellingProductsWithBuyerXml() throws IOException, JAXBException;

    UserWrapperDto findAllUsersBySellingProductsWithBuyerOrderByProductCount() throws IOException;

    UserWithUserCountWithSoldProductsWrapperXmlDto findAllUsersBySellingProductsWithBuyerOrderByProductCountXml() throws IOException, JAXBException;
}
