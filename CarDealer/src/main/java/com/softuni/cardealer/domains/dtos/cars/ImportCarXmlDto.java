package com.softuni.cardealer.domains.dtos.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCarXmlDto {
    @XmlElement
    private String make;

    @XmlElement
    private String model;

    @XmlElement(name = "travelled-distance")
    private Long travelledDistance;
}
