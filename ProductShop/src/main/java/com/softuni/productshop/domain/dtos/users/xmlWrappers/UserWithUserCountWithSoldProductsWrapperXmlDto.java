package com.softuni.productshop.domain.dtos.users.xmlWrappers;

import com.softuni.productshop.domain.dtos.users.UserWithAgeWithSoldProductsXmlDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithUserCountWithSoldProductsWrapperXmlDto {
    @XmlAttribute(name = "count")
    private Integer usersCount;

    @XmlElement(name = "user")
    private List<UserWithAgeWithSoldProductsXmlDto> users;

    public UserWithUserCountWithSoldProductsWrapperXmlDto(List<UserWithAgeWithSoldProductsXmlDto> users) {
        this.users = users;
        this.usersCount = users.size();
    }
}
