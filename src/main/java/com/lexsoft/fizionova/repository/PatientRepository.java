package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.PatientMapper;
import com.lexsoft.fizionova.repository.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PatientRepository {

    @Autowired
    PatientMapper patientMapper;


    public List<Patient> getPatients(String name, String lastname, String phone) {
        List<Patient> patients = patientMapper.findByParam(name, lastname, phone);
        return patients;
    }

     public Patient getPatientById(Integer id) {

        return patientMapper.findPatientById(id);
    }

    public Patient getLastInsertedPatientIdByEmployeeid(Integer employeeId) {
        return patientMapper.getLastInsertedPatientIdByEmployeeid(employeeId);
    }

    public int savePatient(Patient patient) {
        return patientMapper.insertPatient(patient.getName(), patient.getLastname(), patient.getMiddlename(), patient.getPersonalId(),
                patient.getEmail(), patient.getAdressId(), patient.getGender(), patient.getPhone1(), patient.getPhone2(),
                patient.getPathToPatientImage(), patient.getAge(), patient.getForeigner(), patient.getJobTitle(), patient.getEmployeeId());
    }

    public void updatePatient(Patient patient) {
        patientMapper.updatePatient(patient.getIdPatient(),patient.getName(), patient.getLastname(), patient.getMiddlename(), patient.getPersonalId(),
                patient.getEmail(), patient.getAdressId(), patient.getGender(), patient.getPhone1(), patient.getPhone2(),
                patient.getPathToPatientImage(), patient.getAge(), patient.getForeigner(), patient.getJobTitle(), patient.getEmployeeId());
    }



}
