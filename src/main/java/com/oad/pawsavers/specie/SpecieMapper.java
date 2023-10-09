package com.oad.pawsavers.specie;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecieMapper {

    @Mappings({
            @Mapping(source = "id", target = "specieId"),
            @Mapping(source = "name", target = "specieName"),
    })
    SpecieDTO toSpecieDTO(Specie specie);
    List<SpecieDTO> toSpecieDTOList(List<Specie> specieList);

    @InheritInverseConfiguration
    Specie toSpecieEntity(SpecieDTO specieDTO);
    List<Specie> toSpecieEntityList(List<SpecieDTO> specieDTOList);
}
