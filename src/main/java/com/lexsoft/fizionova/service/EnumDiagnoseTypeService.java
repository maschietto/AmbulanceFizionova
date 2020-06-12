package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.EnumDiagnoseTypeRepository;
import com.lexsoft.fizionova.repository.model.EnumDiagnoseType;
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
public class EnumDiagnoseTypeService {


    @Autowired
    EnumDiagnoseTypeRepository enumDiagnoseTypeRepository;

    public ResponseEntity findDiagnoseByParam(Integer id, String diagnoseName) throws BussinesException {
        List<EnumDiagnoseType> diagnoseTypes = enumDiagnoseTypeRepository.findEnumDiagnoseTypeByParam(id, diagnoseName);
        if (diagnoseTypes != null && !diagnoseTypes.isEmpty()) {
            return ResponseEntity.ok(diagnoseTypes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity insertEnumDiagnoseType(EnumDiagnoseType enumDiagnoseType) throws BussinesException {
        List<EnumDiagnoseType> diagnoseTypes = enumDiagnoseTypeRepository.findEnumDiagnoseTypeByParam(null, enumDiagnoseType.getDiagnoseName());
        if (diagnoseTypes != null && !diagnoseTypes.isEmpty()) {
            throw new BussinesException("Therapy type allready exists in database. ");
        } else {
            enumDiagnoseTypeRepository.insertEnumDiagnoseType(enumDiagnoseType);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @Transactional
    public ResponseEntity updateDiagnoseType(EnumDiagnoseType enumDiagnoseType) throws BussinesException {
        List<EnumDiagnoseType> diagnoseTypes = enumDiagnoseTypeRepository.findEnumDiagnoseTypeByParam(enumDiagnoseType.getEnumDiagnoseTypeId(), null);
        if (diagnoseTypes != null && !diagnoseTypes.isEmpty()) {
            enumDiagnoseTypeRepository.update(enumDiagnoseType);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity deleteEnumDiagnoseType(Integer id) throws BussinesException {
        List<EnumDiagnoseType> diagnoseTypes = enumDiagnoseTypeRepository.findEnumDiagnoseTypeByParam(id, null);
        if (diagnoseTypes != null && !diagnoseTypes.isEmpty()) {
            enumDiagnoseTypeRepository.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
