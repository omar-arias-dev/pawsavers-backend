package com.oad.pawsavers.user;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "name", target = "userName"),
            @Mapping(source = "lastname", target = "userLastname"),
            @Mapping(source = "secondLastname", target = "userSecondLastname"),
            @Mapping(source = "gender", target = "userGender"),
            @Mapping(source = "registrationDate", target = "registrationDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "occupation", target = "userOccupation"),
            @Mapping(source = "userType.id", target = "userTypeId"),
    })
    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOList(List<User> userList);

    @InheritInverseConfiguration
    @Mapping(target = "petRescuerList", ignore = true)
    @Mapping(target = "employeeList", ignore = true)
    @Mapping(target = "petAdopterList", ignore = true)
    User toUserEntity(UserDTO userDTO);
}
