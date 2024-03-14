package com.softuni.productshop.domain.dtos.categories.xmlWrapper;

import com.softuni.productshop.domain.dtos.categories.ImportCategoryXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCategoryWrapperXmlDto {
    @XmlElement(name = "category")
    private List<ImportCategoryXmlDto> categories;
}
