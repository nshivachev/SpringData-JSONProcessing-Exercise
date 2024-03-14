package com.softuni.productshop.domain.dtos.users.xmlWrappers;

import com.softuni.productshop.domain.dtos.users.ImportUserXmlDto;
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
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportUserWrapperXmlDto {
    @XmlElement(name = "user")
    private List<ImportUserXmlDto> users;
}
