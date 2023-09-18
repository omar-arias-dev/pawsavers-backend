package com.oad.pawsavers.visits;

import com.oad.pawsavers.employee.EmployeeMapper;
import com.oad.pawsavers.petadopter.PetAdopterMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {
                EmployeeMapper.class,
                PetAdopterMapper.class,
        }
)
public interface VisitDetailsMapper {

    @Mappings({
            @Mapping(source = "visitId", target = "idOfVisit"),
            @Mapping(source = "notes", target = "visitNotes"),
            @Mapping(source = "visitDateTime", target = "visitDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "employee", target = "employeeDTO"),
            @Mapping(source = "petAdopter", target = "petAdopterDTO"),
    })
    VisitDetailsDTO toVisitDetailsDTO(Visit visit);
    List<VisitDetailsDTO> toVisitDetailsDTOList(List<Visit> visitList);

    @InheritInverseConfiguration
    Visit toVisitDetailsEntity(VisitDetailsDTO visitDetailsDTO);
}
