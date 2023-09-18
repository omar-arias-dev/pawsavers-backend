package com.oad.pawsavers.employee;

import com.oad.pawsavers.user.UserMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "employeeId"),
            @Mapping(source = "hireDate", target = "employeeHireDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "user", target = "userDTO"),
    })
    EmployeeDTO toEmployeeDTO(Employee employee);
    List<EmployeeDTO> toEmployeeDTOList(List<Employee> employeeList);

    @InheritInverseConfiguration
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "visitList", ignore = true)
    Employee toEmployeeEntity(EmployeeDTO employeeDTO);
}
