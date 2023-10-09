package com.oad.pawsavers.breed;

import com.oad.pawsavers.specie.SpecieMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                SpecieMapper.class
        }
)
public interface BreedViewMapper {

    @Mappings({
            @Mapping(source = "id", target = "breedId"),
            @Mapping(source = "name", target = "breedName"),
            @Mapping(source = "specie", target = "specieDTO"),
    })
    BreedViewDTO toBreedViewDTO(Breed breed);
    List<BreedViewDTO> toBreedViewDTOList(List<Breed> breedList);
}
