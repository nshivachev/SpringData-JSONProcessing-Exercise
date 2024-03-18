package com.softuni.productshop.domain.dtos.products.xmlWrappers;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceXmlDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWithCountWithNamePriceBuyerWrapperXmlDto {
    @XmlAttribute(name = "count")
    private Integer count;

    @XmlElement(name = "product")
    private List<ProductWithNamePriceXmlDto> sellingProducts;
}
