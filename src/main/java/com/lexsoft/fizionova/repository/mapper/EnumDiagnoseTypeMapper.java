package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.EnumDiagnoseType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface EnumDiagnoseTypeMapper {

    List<EnumDiagnoseType> findEnumDiagnoseTypeByParam(@Param("enumDiagnoseTypeId") Integer enumDiagnoseTypeId,
                                                           @Param("diagnoseName") String diagnoseName);

    int insert(@Param("diagnoseName") String diagnoseName);

    void update(@Param("diagnoseName") String diagnoseName,
                @Param("enumDiagnoseTypeId") Integer enumDiagnoseTypeId);

    void delete(@Param("enumDiagnoseTypeId") Integer enumDiagnoseTypeId);
}
