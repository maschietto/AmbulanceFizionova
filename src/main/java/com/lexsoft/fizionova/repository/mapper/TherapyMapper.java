package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Therapy;
import com.lexsoft.fizionova.repository.model.complexmodel.TherapyComplex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface TherapyMapper {

    Therapy findTherapyById(@Param("idTherapy") Integer idTherapy);
    List<Therapy> findTherapyByParams(@Param("documentId") Integer documentId);
    Therapy findLastInsertedIdTherapy(@Param ("idPatient") Integer idPatient);

    int insert(@Param("documentId") Integer documentId,
               @Param("startTherapyTime") String startTherapyTime,
               @Param("createEmployeeId") Integer createEmployeeId,
               @Param("verifiedEmployeeId") Integer verifiedEmployeeId,
               @Param("therapyTypeIds") String therapyTypeIds,
               @Param("idPatient") Integer idPatient,
               @Param("isVerified") Boolean isVerfied);

    void update(@Param("startTherapyTime") String startTherapyTime,
                @Param("verifiedEmployeeId") Integer verifiedEmployeeId,
                @Param("idTherapy") Integer idTherapy,
                @Param("therapyTypeIds") String therapyTypeIds,
                @Param("idPatient") Integer idPatient,
                @Param("isVerified") Boolean isVerified);

    void deleteTherapy(@Param("therapyId") Integer idTherapy);

    void deleteTherapyByDocumentId(@Param("documentId") Integer documentId);

    List<TherapyComplex> findTherapyByDate(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
    List<Therapy> findTherapiesByPatientId(@Param("idPatient") Integer idPatient);
    Therapy findLastNotVerifiedTherapy(@Param("documentId")Integer documentId);


}
