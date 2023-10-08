package com.oad.pawsavers.vaccine;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccineMapper {

    @Mappings({
            @Mapping(source = "id", target = "vaccineId"),
            @Mapping(source = "name", target = "vaccineName"),
    })
    VaccineDTO toVaccineDTO(Vaccine vaccine);
    List<VaccineDTO> toVaccineDTOList(List<Vaccine> vaccineList);

    @InheritInverseConfiguration
    Vaccine toVaccineEntity(VaccineDTO vaccineDTO);
    List<Vaccine> toVaccineEntityList(List<VaccineDTO> vaccineDTOList);
}
