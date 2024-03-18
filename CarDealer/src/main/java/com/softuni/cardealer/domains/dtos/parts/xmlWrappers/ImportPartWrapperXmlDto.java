package com.softuni.cardealer.domains.dtos.parts.xmlWrappers;

import com.softuni.cardealer.domains.dtos.parts.ImportPartXmlDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportPartWrapperXmlDto {
    @XmlElement(name = "part")
    List<ImportPartXmlDto> parts;
}
