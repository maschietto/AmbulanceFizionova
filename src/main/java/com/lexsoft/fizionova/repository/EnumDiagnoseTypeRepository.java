package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.EnumDiagnoseTypeMapper;
import com.lexsoft.fizionova.repository.model.EnumDiagnoseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public class EnumDiagnoseTypeRepository {

    @Autowired
    EnumDiagnoseTypeMapper enumDiagnoseTypeMapper;


    public int insertEnumDiagnoseType(EnumDiagnoseType enumDiagnoseType) {
        return enumDiagnoseTypeMapper.insert(enumDiagnoseType.getDiagnoseName());
    }

    public List<EnumDiagnoseType> findEnumDiagnoseTypeByParam(Integer id, String diagnoseName) {
        List<EnumDiagnoseType> enumDiagnoseTypes = enumDiagnoseTypeMapper.findEnumDiagnoseTypeByParam(id, diagnoseName);
        return enumDiagnoseTypes;
    }

    public void update(EnumDiagnoseType enumDiagnoseType) {
        enumDiagnoseTypeMapper.update(enumDiagnoseType.getDiagnoseName(), enumDiagnoseType.getEnumDiagnoseTypeId());
    }

    public void delete(Integer id) {
        enumDiagnoseTypeMapper.delete(id);
    }


}