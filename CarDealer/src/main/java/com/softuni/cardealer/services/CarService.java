package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceDto;
import com.softuni.cardealer.domains.dtos.cars.xmlWrappers.CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto;
import com.softuni.cardealer.domains.dtos.cars.xmlWrappers.CarWithPartsWithNameAndPriceWrapperXmlDto;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface CarService {
    List<CarWithMakeAndModelAndDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException;

    CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDescXml(String make) throws IOException, JAXBException;

    List<CarWithPartsWithNameAndPriceDto> findAllWithPartsWithNameAndPrice() throws IOException;

    CarWithPartsWithNameAndPriceWrapperXmlDto findAllWithPartsWithNameAndPriceXml() throws JAXBException;
}
