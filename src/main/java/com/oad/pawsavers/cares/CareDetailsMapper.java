package com.oad.pawsavers.cares;

import com.oad.pawsavers.caretype.CareTypeMapper;
import com.oad.pawsavers.employee.EmployeeMapper;
import com.oad.pawsavers.pet.PetMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                PetMapper.class,
                CareTypeMapper.class,
                EmployeeMapper.class,
        }
)
public interface CareDetailsMapper {

    @Mappings({
            @Mapping(source = "id", target = "careId"),
            @Mapping(source = "pet", target = "petDTO"),
            @Mapping(source = "careType", target = "careTypeDTO"),
            @Mapping(source = "employee", target = "employeeDTO"),
            @Mapping(source = "careDateTimeStart", target = "careDateTimeStart", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "careDateTimeEnd", target = "careDateTimeEnd", dateFormat = "yyyy-MM-dd HH-mm-ss"),
    })
    CareDetailsDTO toCareDetailsDTO(Care care);
    List<CareDetailsDTO> toCareDetailsDTOList(List<Care> careList);

    Care toCareDetailsEntity(CareDetailsDTO careDetailsDTO);
}
