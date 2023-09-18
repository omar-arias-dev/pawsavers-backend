package com.oad.pawsavers.petadopter;

import com.oad.pawsavers.user.UserMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PetAdopterMapper {

    @Mappings({
            @Mapping(source = "id", target = "petAdopterId"),
            @Mapping(source = "homeSize", target = "sizeOfHome"),
            @Mapping(source = "numberOfPets", target = "petsNumber"),
            @Mapping(source = "avatar", target = "petAdopterAvatar"),
            @Mapping(source = "comments", target = "commentsAboutPetAdopter"),
            @Mapping(source = "user", target = "userDTO"),
    })
    PetAdopterDTO toPetAdopterDTO(PetAdopter petAdopter);
    List<PetAdopterDTO> toPetAdopterDTOList(List<PetAdopter> petAdopterList);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "visitList", ignore = true)
    PetAdopter toPetAdopterEntity(PetAdopterDTO petAdopterDTO);
}
