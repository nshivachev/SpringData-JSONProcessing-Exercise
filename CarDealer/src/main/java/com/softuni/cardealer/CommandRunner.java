package com.softuni.cardealer;

import com.softuni.cardealer.services.CarService;
import com.softuni.cardealer.services.CustomerService;
import com.softuni.cardealer.services.SeedService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;

    @Autowired
    public CommandRunner(SeedService seedService, CustomerService customerService, CarService carService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedService.seedAll();

        customerService.getAllOrderByBirthDate();
        carService.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc("Toyota");
    }
}
