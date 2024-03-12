package com.softuni.cardealer;

import com.softuni.cardealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final CustomerService customerService;
    private final CarService carService;
    private final SupplierService supplierService;
    private final SaleService saleService;

    @Autowired
    public CommandRunner(SeedService seedService, CustomerService customerService, CarService carService, SupplierService supplierService, SaleService saleService) {
        this.seedService = seedService;
        this.customerService = customerService;
        this.carService = carService;
        this.supplierService = supplierService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();

        customerService.findAllOrderByBirthDateThenOrderByYoungerDriver();
        carService.findAllByMakeOrderByModelAscThenOrderByTravelledDistanceDesc("Toyota");
        supplierService.findAllByImporterIsFalse();
        carService.findAllWithPartsWithNameAndPrice();
        customerService.findAllBySalesIsNotEmpty();
        saleService.findAllWithCarCustomerPrice();
    }
}
