package com.oad.pawsavers.breed;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BreedMapper {

    @Mappings({
            @Mapping(source = "id", target = "breedId"),
            @Mapping(source = "name", target = "breedName"),
            @Mapping(source = "specie.id", target = "specieId"),
    })
    BreedDTO toBreedDTO(Breed breed);
    List<BreedDTO> toBreedDTOList(List<Breed> breedList);

    @InheritInverseConfiguration
    Breed toBreedEntity(BreedDTO breedDTO);
}
