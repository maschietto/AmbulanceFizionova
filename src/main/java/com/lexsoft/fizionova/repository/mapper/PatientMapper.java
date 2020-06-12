package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Maschietto on 2/14/17.
 */
@Mapper
public interface PatientMapper {

    List<Patient> findByParam(@Param("name") String name, @Param("lastname") String lastname, @Param("phone1") String phone1);

    Patient findPatientById(@Param("id") Integer id);

    Patient getLastInsertedPatientIdByEmployeeid(@Param("employeeId") Integer employeeId);

    int insertPatient(@Param("name") String name, @Param("lastname") String lastname,
                      @Param("middlename") String middlename, @Param("personalId") String perosnalId,
                      @Param("email") String email, @Param("adressId") Integer adressId,
                      @Param("gender") String gender, @Param("phone1") String phone1, @Param("phone2") String phone2,
                      @Param("pathToPatientImage") String pathToPatientImage,@Param("age") String age,
                      @Param("isForeigner") Boolean isForeigner, @Param("jobTitle") String jobTitle,
                      @Param("employeeId") Integer employeeId);


    void updatePatient(@Param("idPatient") Integer idPatient,
                       @Param("name") String name, @Param("lastname") String lastname,
                       @Param("middlename") String middlename, @Param("personalId") String perosnalId,
                       @Param("email") String email, @Param("adressId") Integer adressId,
                       @Param("gender") String gender, @Param("phone1") String phone1, @Param("phone2") String phone2,
                       @Param("pathToPatientImage") String pathToPatientImage,@Param("age") String age,
                       @Param("isForeigner") Boolean isForeigner, @Param("jobTitle") String jobTitle,
                       @Param("employeeId") Integer employeeId);


}
