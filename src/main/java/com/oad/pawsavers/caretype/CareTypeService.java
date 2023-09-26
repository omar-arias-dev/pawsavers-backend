package com.oad.pawsavers.caretype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareTypeService {

    @Autowired
    private CareTypeRepository careTypeRepository;

    @Autowired
    private CareTypeMapper careTypeMapper;

    public List<CareTypeDTO> getAllCareTypes() {
        return careTypeMapper.toCareTypeDTOList(careTypeRepository.findAll());
    }

    public Optional<CareTypeDTO> getCareTypeById(long id) {
        return careTypeRepository.findById(id)
                .map(careTypeMapper::toCareTypeDTO);
    }

    public CareType createCareType(CareTypeDTO careTypeDTO) {
        return careTypeRepository.save(careTypeMapper.toCareTypeEntity(careTypeDTO));
    }

    public boolean updateCareTypeById(long id, CareTypeDTO careTypeDTO) {
        Optional<CareType> careType = careTypeRepository.findById(id);
        if (careType.isPresent()) {
            CareType careTypeToUpdate = careType.get();
            careTypeToUpdate.setCareName(careTypeDTO.getNameOfCare());
            careTypeRepository.save(careTypeToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCareTypeById(long id) {
        if (getCareTypeById(id).isPresent()) {
            careTypeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
