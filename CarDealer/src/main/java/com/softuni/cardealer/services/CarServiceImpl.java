package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.CarWithMakeModelDistanceDto;
import com.softuni.cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.CAS_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Utils.writeJsonIntoFile;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarWithMakeModelDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make) throws IOException {
        final List<CarWithMakeModelDistanceDto> cars = carRepository.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(make);

        writeJsonIntoFile(cars, CAS_OUTPUT_JSON_PATH);

        return cars;
    }
}
