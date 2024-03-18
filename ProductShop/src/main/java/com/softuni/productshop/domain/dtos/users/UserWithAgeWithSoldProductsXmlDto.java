package com.softuni.productshop.domain.dtos.users;

import com.softuni.productshop.domain.dtos.products.xmlWrappers.ProductWithCountWithNamePriceBuyerWrapperXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithAgeWithSoldProductsXmlDto {
    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute
    private String age;

    @XmlElement(name = "sold-products")
    private ProductWithCountWithNamePriceBuyerWrapperXmlDto sellingProducts;

    public UserWithAgeWithSoldProductsXmlDto setSellingProductsCount() {
        sellingProducts.setCount(sellingProducts.getSellingProducts().size());
        return this;
    }
}
