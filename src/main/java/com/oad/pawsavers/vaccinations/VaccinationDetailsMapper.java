package com.oad.pawsavers.vaccinations;

import com.oad.pawsavers.pet.PetMapper;
import com.oad.pawsavers.vaccine.VaccineMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PetMapper.class,
                VaccineMapper.class
        }
)
public interface VaccinationDetailsMapper {

        @Mappings({
                @Mapping(source = "id", target = "vaccinationId"),
                @Mapping(source = "pet", target = "petDTO"),
                @Mapping(source = "vaccine", target = "vaccineDTO"),
                @Mapping(source = "vaccinationDate", target = "vaccinationDate", dateFormat = "yyyy-MM-dd"),
        })
        VaccinationDetailsDTO toVaccinationDetailsDTO(Vaccination vaccination);
        List<VaccinationDetailsDTO> toVaccinationDetailsDTOList(List<Vaccination> vaccinationList);
}
