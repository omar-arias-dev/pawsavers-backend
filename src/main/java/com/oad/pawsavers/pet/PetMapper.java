package com.oad.pawsavers.pet;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {

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
            @Mapping(source = "specie.id", target = "specieId"),
            @Mapping(source = "breed.id", target = "breedId"),
    })
    PetDTO toPetDTO(Pet pet);
    List<PetDTO> toPetDTOList(List<Pet> petList);

    @InheritInverseConfiguration
    @Mapping(target = "registrationDateTime", ignore = true)
    Pet toPetEntity(PetDTO petDTO);
}
