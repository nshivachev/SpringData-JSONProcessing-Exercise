package com.softuni.cardealer.domains.dtos.sales.xmlWrappers;

import com.softuni.cardealer.domains.dtos.sales.SaleWithPriceAndDiscountXmlDto;
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
@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithPriceAndDiscountWrapperXmlDto {
    @XmlElement(name = "sale")
    private List<SaleWithPriceAndDiscountXmlDto> sales;
}
