package com.softuni.cardealer.domains.dtos.sales;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "sale")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithPriceAndDiscountXmlDto {
    @XmlElement
    private CarWithMakeAndModelAndDistanceXmlDto car;

    @XmlElement(name = "customer-name")
    private String customerName;

    @XmlElement
    private Float discount;

    @XmlElement
    BigDecimal price;

    @XmlElement(name = "price-with-discount")
    BigDecimal priceWithDiscount;
}
