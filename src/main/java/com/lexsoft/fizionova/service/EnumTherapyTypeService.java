package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.EnumTherapyTypeRepository;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Maschietto on 2/16/17.
 */
@Service
public class EnumTherapyTypeService {


    @Autowired
    EnumTherapyTypeRepository enumTherapyTypeRepository;

    public ResponseEntity findTherapyByParam(Integer id, String typeName) throws BussinesException {
        List<EnumTherapyType> enumTherapyType = enumTherapyTypeRepository.findEnumTherapyTypeByParam(id, typeName);

        if (enumTherapyType != null) {
            return ResponseEntity.ok(enumTherapyType);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity insertEnumtherapyType(EnumTherapyType enumTherapyType) throws BussinesException {
        List<EnumTherapyType> therapyType = enumTherapyTypeRepository.findEnumTherapyTypeByParam(null, enumTherapyType.getEnumTherapyTypeName());
        if (therapyType != null && !therapyType.isEmpty()) {
            throw new BussinesException("Therapy type allready exists in database. ");
        } else {
            enumTherapyTypeRepository.insertEnumTherapyType(enumTherapyType);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @Transactional
    public ResponseEntity updateTherapyType(EnumTherapyType enumTherapyType) throws BussinesException {
        List<EnumTherapyType> enumTherapyType1 = enumTherapyTypeRepository.findEnumTherapyTypeByParam(enumTherapyType.getEnumTherapyTypeId(), null);
        if (enumTherapyType1 != null) {
            enumTherapyTypeRepository.update(enumTherapyType);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity deleteEnumTherapyType(Integer id) throws BussinesException {
        List<EnumTherapyType> enumTherapyType = enumTherapyTypeRepository.findEnumTherapyTypeByParam(id, null);
        if (enumTherapyType != null) {
            enumTherapyTypeRepository.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
