package com.softuni.cardealer.services;

import com.softuni.cardealer.domains.dtos.suppliers.SupplierWithNameAndPartsCountDto;
import com.softuni.cardealer.domains.dtos.suppliers.xmlWrappers.SupplierWithNameAndPartsCountWrapperXmlDto;
import com.softuni.cardealer.domains.entities.Supplier;
import com.softuni.cardealer.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

import static com.softuni.cardealer.constants.Paths.SUPPLIERS_OUTPUT_JSON_PATH;
import static com.softuni.cardealer.constants.Paths.SUPPLIERS_OUTPUT_XML_PATH;
import static com.softuni.cardealer.constants.Utils.writeJsonIntoFile;
import static com.softuni.cardealer.constants.Utils.writeXmlIntoFile;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierWithNameAndPartsCountDto> findAllByImporterIsFalse() throws IOException {
        List<SupplierWithNameAndPartsCountDto> suppliers = supplierRepository.findAllByImporterIsFalse()
                .stream()
                .map(Supplier::toSupplierWithNamePartsCountDto)
                .toList();

        writeJsonIntoFile(suppliers, SUPPLIERS_OUTPUT_JSON_PATH);

        return suppliers;
    }

    @Override
    public SupplierWithNameAndPartsCountWrapperXmlDto findAllByImporterIsFalseXml() throws JAXBException {
        SupplierWithNameAndPartsCountWrapperXmlDto suppliers = new SupplierWithNameAndPartsCountWrapperXmlDto(
                supplierRepository.findAllByImporterIsFalse()
                .stream()
                .map(Supplier::toSupplierWithNamePartsCountXmlDto)
                .toList());

        writeXmlIntoFile(suppliers, SUPPLIERS_OUTPUT_XML_PATH);

        return suppliers;
    }
}
