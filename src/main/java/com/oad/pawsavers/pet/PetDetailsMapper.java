package com.oad.pawsavers.pet;

import com.oad.pawsavers.color.ColorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                ColorMapper.class
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
            @Mapping(source = "registrationDateTime", target = "registrationDateTime", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "rescueDate", target = "rescueDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "avatar", target = "petAvatar"),
            @Mapping(source = "colorList", target = "colorDTOList")
    })
    PetDetailsDTO toPetDetailsDTO(Pet pet);
    List<PetDetailsDTO> toPetDetailsDTOList(List<Pet> petList);

    Pet toPetDetailsEntity(PetDetailsDTO petDetailsDTO);
    List<Pet> toPetDetailsEntityList(List<PetDetailsDTO> petDetailsDTOList);
}
