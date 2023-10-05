package com.oad.pawsavers.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ColorMapper colorMapper;

    public List<ColorDTO> getAllColors() {
        return colorMapper.toColorDTOList(colorRepository.findAll());
    }

    public Optional<ColorDTO> getColorById(long colorId) {
        return colorRepository.findById(colorId)
                .map(colorMapper::toColorDTO);
    }

    public ColorDTO createColor(ColorDTO colorDTO) {
        if (!colorRepository.existsColorByNameOrHex(colorDTO.getName(), colorDTO.getHexColor())) {
            colorRepository.save(colorMapper.toColorEntity(colorDTO));
            return colorDTO;
        } else {
            return null;
        }
    }

    public boolean deleteColorById(long colorId) {
        if (colorRepository.existsById(colorId)) {
            colorRepository.deleteById(colorId);
            return true;
        } else {
            return false;
        }
    }

    public ColorDTO updateColorById(long colorId, ColorDTO colorDTO) {
        Optional<Color> optionalColor = colorRepository.findById(colorId);
        if (optionalColor.isPresent()) {
            if (!colorRepository.existsColorByNameOrHex(colorDTO.getName(), colorDTO.getHexColor())) {
                Color colorToUpdate = optionalColor.get();
                colorToUpdate.setName(colorDTO.getName());
                colorToUpdate.setHex(colorDTO.getHexColor());
                return colorMapper.toColorDTO(colorRepository.save(colorToUpdate));
            } else {
                System.out.println("Hex code or color name already exists");
                return null;
            }
        } else {
            System.out.println("Color not exists.");
            return null;
        }
    }
}
