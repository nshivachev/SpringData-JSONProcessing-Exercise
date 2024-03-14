package com.softuni.productshop.domain.dtos.products.xmlWrappers;

import com.softuni.productshop.domain.dtos.products.ImportProductXmlDto;
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
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProductWrapperXmlDto {
    @XmlElement(name = "product")
    private List<ImportProductXmlDto> products;
}
