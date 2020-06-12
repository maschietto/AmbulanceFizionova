package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.repository.model.joinDomain.DocumentCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DocumentMapper {

    List<DocumentCollection> findDocumentsByParams(@Param("patientId") Integer patientId,
                                                   @Param("documentId") Integer documentId,
                                                   @Param("registerNumber") String registerNUmber);

    List<Document> findOnlyDocsByParams(@Param("patientId") Integer patientId,
                                         @Param("documentId") Integer documentId,
                                         @Param("registerNumber") String registerNumber);

    Document findDocByRegisterNumber(@Param("registerNumber") String registerNumber);

    Document findDocumentById(@Param("documentId") Integer documentId);

    Document getLastCreateDocByPatientId(@Param("idPatient") Integer patientId);


    int insertDocument(@Param("diagnose") String diagnose, @Param("functionalDiagnose") String functionalDiagnose,
               @Param("description") String description,
               @Param("skeletImagePath") String skeletImagePath,
               @Param("therapyDetails") String therapyDetails, @Param("therapyPurpose") String therapyPurpose,
               @Param("therapyPlan") String therapyPlan, @Param("therapyMarks") String therapyMarks,
               @Param("therapyConclusion") String therapyConclusion, @Param("idPatient") Integer idPatient,
               @Param("registerNumber") String registerNumber, @Param("idEmployee") Integer idEmployee);

    void updateDocument(@Param("diagnose") String diagnose, @Param("functionalDiagnose") String functionalDiagnose,
                @Param("description") String description, @Param("skeletImagePath") String skeletImagePath,
                @Param("therapyDetails") String therapyDetails, @Param("therapyPurpose") String therapyPurpose,
                @Param("therapyPlan") String therapyPlan, @Param("therapyMarks") String therapyMarks,
                @Param("therapyConclusion") String therapyConclusion, @Param("documentId") Integer documentId);

    void deleteDocument(@Param("documentId") Integer documentId);


    Document findLastCreatedDocument(@Param("idPatient") Integer idPatient);

}
