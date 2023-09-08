package com.oad.pawsavers.petRescuer;

import com.oad.pawsavers.user.UserMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PetRescuerMapper {

    @Mapping(source = "user", target = "userDTO")
    PetRescuerDTO toPetRescuerDTO(PetRescuer petRescuer);
    List<PetRescuerDTO> toPetRescuerDTOList(List<PetRescuer> petRescuerList);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    PetRescuer toPetRescuerEntity(PetRescuerDTO petRescuerDTO);
}
