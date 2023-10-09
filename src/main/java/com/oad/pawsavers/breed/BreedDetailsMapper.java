package com.oad.pawsavers.breed;

import com.oad.pawsavers.pet.PetMapper;
import com.oad.pawsavers.specie.SpecieMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                SpecieMapper.class,
                PetMapper.class,
        }
)
public interface BreedDetailsMapper {

    @Mappings({
            @Mapping(source = "id", target = "breedId"),
            @Mapping(source = "name", target = "breedName"),
            @Mapping(source = "petList", target = "petDTOList"),
    })
    BreedDetailsDTO toBreedDetailsDTO(Breed breed);
    List<BreedDetailsDTO> toBreedDetailsDTOList(List<Breed> breedList);
}
