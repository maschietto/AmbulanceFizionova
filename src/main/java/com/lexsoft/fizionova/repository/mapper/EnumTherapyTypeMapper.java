package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EnumTherapyTypeMapper {

    List<EnumTherapyType> findEnumTherapyTypeByParam(@Param("enumTherapyTypeId") Integer enumTherapyTypeId,
                                                    @Param("enumTherapyTypeName") String enumTherapyTypeName);

    int insert(@Param("enumTherapyTypeName") String enumTherapyTypeName);

    void update(@Param("enumTherapyTypeName") String enumTherapyTypeName,
                @Param("enumTherapyTypeId") Integer enumTherapyTypeId);

    void delete(@Param("enumTherapyTypeId") Integer enumTherapyTypeId);
}
