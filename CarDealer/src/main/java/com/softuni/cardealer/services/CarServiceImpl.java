package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithPartsWithNameAndPriceDto;
import com.softuni.cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.CARS_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Paths.CARS_PARTS_NAME_PRICE_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Utils.MODEL_MAPPER;
import static com.softuni.cardealer.constants.Utils.writeJsonIntoFile;

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
    public List<CarWithPartsWithNameAndPriceDto> findAllWithPartsWithNameAndPrice() throws IOException {
        List<CarWithPartsWithNameAndPriceDto> cars = carRepository.findAll()
                .stream()
                .map(car -> MODEL_MAPPER.map(car, CarWithPartsWithNameAndPriceDto.class))
                .toList();

        writeJsonIntoFile(cars, CARS_PARTS_NAME_PRICE_OUTPUT_JSON_PATH);

        return cars;
    }
}
