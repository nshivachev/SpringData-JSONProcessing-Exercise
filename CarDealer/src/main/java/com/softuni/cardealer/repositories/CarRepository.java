package com.softuni.cardealer.repositories;

import com.softuni.cardealer.domains.dtos.cars.CarWithIdAndMakeAndModelAndDistanceXmlDto;
import com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto;
import com.softuni.cardealer.domains.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "select * from `car_dealer`.cars order by rand() limit 1", nativeQuery = true)
    Optional<Car> getRandomEntity();

    @Query("select new com.softuni.cardealer.domains.dtos.cars.CarWithMakeAndModelAndDistanceDto(c.id, c.make, c.model, c.travelledDistance) from Car c where c.make = :make order by c.model asc, c.travelledDistance desc")
    List<CarWithMakeAndModelAndDistanceDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc(String make);

    @Query("select new com.softuni.cardealer.domains.dtos.cars.CarWithIdAndMakeAndModelAndDistanceXmlDto(c.id, c.make, c.model, c.travelledDistance) from Car c where c.make = :make order by c.model asc, c.travelledDistance desc")
    List<CarWithIdAndMakeAndModelAndDistanceXmlDto> findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDescXml(String make);
}

