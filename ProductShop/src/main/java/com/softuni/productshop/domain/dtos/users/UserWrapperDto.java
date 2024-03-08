package com.softuni.productshop.domain.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapperDto {
    private Long usersCount;
    private List<UserWithSellingProductsDto> users;
}
