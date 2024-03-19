package com.softuni.cardealer.domains.dtos.cars.xmlWrappers;

import com.softuni.cardealer.domains.dtos.cars.CarWithIdAndMakeAndModelAndDistanceXmlDto;
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
@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto {
    @XmlElement(name = "car")
    private List<CarWithIdAndMakeAndModelAndDistanceXmlDto> cars;
}
