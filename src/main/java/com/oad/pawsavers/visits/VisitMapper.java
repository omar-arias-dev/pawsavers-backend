package com.oad.pawsavers.visits;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    @Mappings({
            @Mapping(source = "visitId", target = "idOfVisit"),
            @Mapping(source = "notes", target = "visitNotes"),
            @Mapping(source = "visitDateTime", target = "visitDate", dateFormat = "yyyy-MM-dd HH-mm-ss"),
            @Mapping(source = "employee.id", target = "employeeId"),
            @Mapping(source = "petAdopter.id", target = "petAdopterId")
    })
    VisitDTO toVisitDTO(Visit visit);
    List<VisitDTO> toVisitDTOList(List<Visit> visitList);

    @InheritInverseConfiguration
    Visit toVisitEntity(VisitDTO visitDTO);
}

