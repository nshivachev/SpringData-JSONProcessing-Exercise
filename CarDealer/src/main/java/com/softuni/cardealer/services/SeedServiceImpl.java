package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.cars.ImportCarDto;
import com.softuni.cardealer.domains.dtos.customers.ImportCustomerDto;
import com.softuni.cardealer.domains.dtos.parts.ImportPartDto;
import com.softuni.cardealer.domains.dtos.suppliers.ImportSupplierDto;
import com.softuni.cardealer.domains.entities.*;
import com.softuni.cardealer.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.softuni.cardealer.constants.Paths.*;
import static com.softuni.cardealer.constants.Utils.GSON;
import static com.softuni.cardealer.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {
    private final SupplierRepository supplierRepository;
    private final PartRepository partRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public SeedServiceImpl(SupplierRepository supplierRepository, PartRepository partRepository, CarRepository carRepository, CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.supplierRepository = supplierRepository;
        this.partRepository = partRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (supplierRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(SUPPLIERS_INPUT_JSON_PATH.toFile());

        supplierRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, ImportSupplierDto[].class))
                        .map(supplierDto -> MODEL_MAPPER.map(supplierDto, Supplier.class))
                        .toList());

        fileReader.close();
    }

    @Override
    public void seedParts() throws IOException {
        if (partRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(PARTS_INPUT_JSON_PATH.toFile());

        partRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, ImportPartDto[].class))
                        .map(partDto -> MODEL_MAPPER.map(partDto, Part.class))
                        .map(this::setRandomSupplier)
                        .toList());

        fileReader.close();
    }

    @Override
    public void seedCars() throws IOException {
        if (carRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(CARS_INPUT_JSON_PATH.toFile());

        carRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, ImportCarDto[].class))
                        .map(carDto -> MODEL_MAPPER.map(carDto, Car.class))
                        .map(this::setRandomPart)
                        .toList());

        fileReader.close();
    }

    @Override
    public void seedCustomers() throws IOException {
        if (customerRepository.count() != 0) return;

        final FileReader fileReader = new FileReader(CUSTOMERS_INPUT_JSON_PATH.toFile());

        customerRepository.saveAllAndFlush(
                Arrays.stream(GSON.fromJson(fileReader, ImportCustomerDto[].class))
                        .map(customerDto -> MODEL_MAPPER.map(customerDto, Customer.class))
                        .toList());

        fileReader.close();
    }

    @Override
    public void seedSales() {
        if (saleRepository.count() != 0) return;

        final long numberOfSales = new Random().nextLong(carRepository.count());

        final Set<Car> cars = new HashSet<>();

        LongStream.range(0, numberOfSales)
                .forEach(number ->
                        cars.add(carRepository.getRandomEntity().orElseThrow(NoSuchElementException::new)));

        final List<Sale> sales = new ArrayList<>();

        final List<Float> discounts = List.of(0.0f, 0.05f, 0.1f, 0.15f, 0.2f, 0.3f, 0.4f, 0.5f);

        cars.forEach(car -> {
            Customer customer = customerRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            float discount = discounts.get(new Random().nextInt(discounts.size()));

            if (customer.isYoungDriver()) {
                discount = (float) (discount + 0.05);
            }

            sales.add(new Sale(discount, car, customer));
        });

        saleRepository.saveAllAndFlush(sales);
    }

    private Car setRandomPart(Car car) {
        final int numberOfParts = new Random().nextInt(3, 6);

        final Set<Part> parts = new HashSet<>();

        IntStream.range(0, numberOfParts)
                .forEach(number ->
                        parts.add(partRepository.getRandomEntity().orElseThrow(NoSuchElementException::new)));

        car.setParts(parts);

        return car;
    }

    private Part setRandomSupplier(Part part) {
        final Supplier supplier = supplierRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

        part.setSupplier(supplier);

        return part;
    }
}
