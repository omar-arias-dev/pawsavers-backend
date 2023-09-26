package com.oad.pawsavers.caretype;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CareTypeMapper {

    @Mappings({
            @Mapping(source = "id", target = "careTypeId"),
            @Mapping(source = "careName", target = "nameOfCare"),
    })
    CareTypeDTO toCareTypeDTO(CareType careType);
    List<CareTypeDTO> toCareTypeDTOList(List<CareType> careTypeList);

    @InheritInverseConfiguration
    CareType toCareTypeEntity(CareTypeDTO careTypeDTO);
}
