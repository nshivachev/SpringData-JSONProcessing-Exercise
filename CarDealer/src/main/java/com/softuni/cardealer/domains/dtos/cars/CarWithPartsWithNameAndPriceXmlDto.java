package com.softuni.cardealer.domains.dtos.cars;

import com.softuni.cardealer.domains.dtos.parts.xmlWrappers.PartWithNameAndPriceWrapperXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsWithNameAndPriceXmlDto {
    @XmlAttribute
    private String make;

    @XmlAttribute
    private String model;

    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;

    @XmlElement
    private PartWithNameAndPriceWrapperXmlDto parts;
}
