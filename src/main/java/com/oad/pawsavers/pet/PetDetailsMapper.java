package com.oad.pawsavers.pet;

import com.oad.pawsavers.breed.BreedMapper;
import com.oad.pawsavers.color.ColorMapper;
import com.oad.pawsavers.specie.SpecieMapper;
import com.oad.pawsavers.vaccinations.VaccinationMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                SpecieMapper.class,
                BreedMapper.class,
                ColorMapper.class,
                VaccinationMapper.class,
        }
)
public interface PetDetailsMapper {

    @Mappings({
            @Mapping(source = "id", target = "petId"),
            @Mapping(source = "name", target = "petName"),
            @Mapping(source = "age", target = "petAge"),
            @Mapping(source = "size", target = "petSize"),
            @Mapping(source = "personality", target = "petPersonality"),
            @Mapping(source = "status", target = "petStatus"),
            @Mapping(source = "registrationDateTime", target = "registrationDateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "rescueDate", target = "rescueDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "avatar", target = "petAvatar"),
            @Mapping(source = "specie", target = "specieDTO"),
            @Mapping(source = "breed", target = "breedDTO"),
            @Mapping(source = "colorList", target = "colorDTOList"),
            @Mapping(source = "vaccinationList", target = "vaccinationDTOList"),
    })
    PetDetailsDTO toPetDetailsDTO(Pet pet);
    List<PetDetailsDTO> toPetDetailsDTOList(List<Pet> petList);

    Pet toPetDetailsEntity(PetDetailsDTO petDetailsDTO);
    List<Pet> toPetDetailsEntityList(List<PetDetailsDTO> petDetailsDTOList);
}
