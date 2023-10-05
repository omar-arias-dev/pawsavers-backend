package com.oad.pawsavers.cares;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CareMapper {

    @Mappings({
            @Mapping(source = "id", target = "careId"),
            @Mapping(source = "pet.id", target = "petId"),
            @Mapping(source = "careType.id", target = "careTypeId"),
            @Mapping(source = "employee.id", target = "employeeId"),
            @Mapping(source = "careDateTimeStart", target = "careDateTimeStart", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "careDateTimeEnd", target = "careDateTimeEnd", dateFormat = "yyyy-MM-dd HH-mm-ss"),
    })
    CareDTO toCareDTO(Care care);

    @InheritInverseConfiguration
    Care toCareEntity(CareDTO careDTO);
}
