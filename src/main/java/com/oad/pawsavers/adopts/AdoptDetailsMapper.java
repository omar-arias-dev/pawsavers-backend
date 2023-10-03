package com.oad.pawsavers.adopts;

import com.oad.pawsavers.pet.PetMapper;
import com.oad.pawsavers.petadopter.PetAdopterMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PetMapper.class,
                PetAdopterMapper.class
        }
)
public interface AdoptDetailsMapper {

    @Mappings({
            @Mapping(source = "id", target = "adoptId"),
            @Mapping(source = "pet", target = "petDTO"),
            @Mapping(source = "petAdopter", target = "petAdopterDTO"),
            @Mapping(source = "adoptDate", target = "adoptDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "notes", target = "adoptNotes"),
    })
    AdoptDetailsDTO toAdoptDetailsDTO(Adopt adopt);
    List<AdoptDetailsDTO> toAdoptDetailsDTOList(List<Adopt> adoptList);

    @InheritInverseConfiguration
    Adopt toAdoptDetailsEntity(AdoptDetailsDTO adoptDetailsDTO);
}
