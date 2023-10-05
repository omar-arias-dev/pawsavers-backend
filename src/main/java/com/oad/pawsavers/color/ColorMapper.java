package com.oad.pawsavers.color;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    @Mappings({
            @Mapping(source = "id", target = "colorId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "hex", target = "hexColor"),
    })
    ColorDTO toColorDTO(Color color);
    List<ColorDTO> toColorDTOList(List<Color> colorList);

    @InheritInverseConfiguration
    Color toColorEntity(ColorDTO colorDTO);
    List<Color> toColorEntityList(List<ColorDTO> colorDTOList);
}
