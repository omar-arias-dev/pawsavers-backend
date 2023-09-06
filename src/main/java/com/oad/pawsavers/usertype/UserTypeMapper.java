package com.oad.pawsavers.usertype;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTypeMapper {

    @Mappings({
            @Mapping(source = "id", target = "userTypeId"),
            @Mapping(source = "type", target = "typeOfUser"),
    })
    UserTypeDTO toUserTypeDTO(UserType userType);
    List<UserTypeDTO> toUserTypeDTOList(List<UserType> userTypeList);

    @InheritInverseConfiguration
    UserType toUserTypeEntity(UserTypeDTO userTypeDTO);
}
