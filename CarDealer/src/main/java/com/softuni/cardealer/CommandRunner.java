package com.softuni.cardealer;

import com.softuni.cardealer.services.CarService;
import com.softuni.cardealer.services.CustomerService;
import com.softuni.cardealer.services.SeedService;
import com.softuni.cardealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;

    @Autowired
    public CommandRunner(SeedService seedService, CustomerService customerService, CarService carService, SupplierService supplierService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();

        customerService.findAllOrderByBirthDateThenOrderByYoungerDriver();
        carService.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc("Toyota");
        supplierService.findAllByImporterIsFalse();
        carService.findAllWithPartsWithNameAndPrice();
        customerService.findAllBySalesIsNotEmpty();
    }
}
