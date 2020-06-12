package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.EnumTherapyTypeMapper;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public class EnumTherapyTypeRepository {

    @Autowired
    EnumTherapyTypeMapper enumTherapyTypeMapper;


    public int insertEnumTherapyType(EnumTherapyType therapyType) {
        return enumTherapyTypeMapper.insert(therapyType.getEnumTherapyTypeName());
    }

    public List<EnumTherapyType> findEnumTherapyTypeByParam(Integer id, String typeName) {
       List <EnumTherapyType> enumTherapyType = enumTherapyTypeMapper.findEnumTherapyTypeByParam(id, typeName);
        return enumTherapyType;
    }

    public void update(EnumTherapyType therapyType) {
        enumTherapyTypeMapper.update( therapyType.getEnumTherapyTypeName(), therapyType.getEnumTherapyTypeId());
    }

    public void delete(Integer id) {
        enumTherapyTypeMapper.delete(id);
    }


}