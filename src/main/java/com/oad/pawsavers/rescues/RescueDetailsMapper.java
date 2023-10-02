package com.oad.pawsavers.rescues;

import com.oad.pawsavers.pet.PetMapper;
import com.oad.pawsavers.petrescuer.PetRescuerMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PetMapper.class,
                PetRescuerMapper.class
        }
)
public interface RescueDetailsMapper {

    @Mappings({
            @Mapping(source = "id", target = "rescuedPetId"),
            @Mapping(source = "pet", target = "petDTO"),
            @Mapping(source = "petRescuer", target = "petRescuerDTO"),
    })
    RescueDetailsDTO toRescueDetailsDTO(Rescue rescue);
    List<RescueDetailsDTO> toRescueDTOList(List<Rescue> rescueList);

    Rescue toRescueEntity(RescueDetailsDTO rescueDetailsDTO);
}
