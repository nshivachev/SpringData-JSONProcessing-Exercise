package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.suppliers.SupplierWithNamePartsCountDto;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    List<SupplierWithNamePartsCountDto> findAllByImporterIsFalse() throws IOException;
}
