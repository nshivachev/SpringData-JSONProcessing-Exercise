package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.suppliers.ImportSupplierDto;
import com.softuni.cardealer.domains.entities.Supplier;
import com.softuni.cardealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static com.softuni.cardealer.constants.Paths.SUPPLIERS_INPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Utils.GSON;
import static com.softuni.cardealer.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SeedServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
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
    public void seedParts() {

    }

    @Override
    public void seedCars() {

    }

    @Override
    public void seedCustomers() {

    }

    @Override
    public void seedSales() {

    }
}
