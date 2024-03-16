package com.softuni.productshop.domain.dtos.categories.xmlWrapper;

import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryProductSummaryWrapperXmlDto {
        @XmlElement(name = "category")
    List<CategoryProductSummaryXmlDto> categories;
}
