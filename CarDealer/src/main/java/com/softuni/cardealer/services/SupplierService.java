package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.suppliers.SupplierWithNameAndPartsCountDto;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    List<SupplierWithNameAndPartsCountDto> findAllByImporterIsFalse() throws IOException;
}
