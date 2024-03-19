package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceXmlDto;
import com.softuni.cardealer.domains.dtos.cars.xmlWrappers.CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto;
import com.softuni.cardealer.domains.dtos.cars.xmlWrappers.CarWithPartsWithNameAndPriceWrapperXmlDto;
import com.softuni.cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.*;
import static com.softuni.cardealer.constants.Utils.*;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarWithMakeAndModelAndDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException {
        final List<CarWithMakeAndModelAndDistanceDto> cars = carRepository.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(make);

        writeJsonIntoFile(cars, CARS_OUTPUT_JSON_PATH);

        return cars;
    }

    @Override
    public CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDescXml(String make) throws JAXBException {
        final CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto cars = new CarWithIdAndMakeAndModelAndDistanceWrapperXmlDto(
                carRepository.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDescXml(make));

        writeXmlIntoFile(cars, CARS_OUTPUT_XML_PATH);

        return cars;
    }

    @Override
    public List<CarWithPartsWithNameAndPriceDto> findAllWithPartsWithNameAndPrice() throws IOException {
        List<CarWithPartsWithNameAndPriceDto> cars = carRepository.findAll()
                .stream()
                .map(car -> MODEL_MAPPER.map(car, CarWithPartsWithNameAndPriceDto.class))
                .toList();

        writeJsonIntoFile(cars, CARS_PARTS_NAME_PRICE_OUTPUT_JSON_PATH);

        return cars;
    }

    @Override
    public CarWithPartsWithNameAndPriceWrapperXmlDto findAllWithPartsWithNameAndPriceXml() throws JAXBException {
        CarWithPartsWithNameAndPriceWrapperXmlDto cars = new CarWithPartsWithNameAndPriceWrapperXmlDto(
                carRepository.findAll()
                        .stream()
                        .map(car -> MODEL_MAPPER.map(car, CarWithPartsWithNameAndPriceXmlDto.class))
                        .toList());

        writeXmlIntoFile(cars, CARS_PARTS_NAME_PRICE_OUTPUT_XML_PATH);

        return cars;
    }
}
