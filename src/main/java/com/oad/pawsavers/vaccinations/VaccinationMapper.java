package com.oad.pawsavers.vaccinations;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccinationMapper {

    @Mappings({
            @Mapping(source = "id", target = "vaccinationId"),
            @Mapping(source = "pet.id", target = "petId"),
            @Mapping(source = "vaccine.id", target = "vaccineId"),
            @Mapping(source = "vaccinationDate", target = "vaccinationDate", dateFormat = "yyyy-MM-dd"),
    })
    VaccinationDTO toVaccinationDTO(Vaccination vaccination);
    List<VaccinationDTO> toVaccinationDTOList(List<Vaccination> vaccinationList);

    @InheritInverseConfiguration
    Vaccination toVaccinationEntity(VaccinationDTO vaccinationDTO);
    List<Vaccination> toVaccinationEntityList(List<VaccinationDTO> vaccinationDTOList);
}
