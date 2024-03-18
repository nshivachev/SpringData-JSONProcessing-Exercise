package com.softuni.cardealer.domains.dtos.suppliers.xmlWrappers;

import com.softuni.cardealer.domains.dtos.suppliers.ImportSupplierXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportSupplierWrapperXmlDto {
    @XmlElement(name = "supplier")
    private List<ImportSupplierXmlDto> suppliers;
}
