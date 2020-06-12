package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.model.wrapper.PatientWrapper;
import com.lexsoft.fizionova.repository.AdressRepository;
import com.lexsoft.fizionova.repository.DocumentRepository;
import com.lexsoft.fizionova.repository.EmployeeRepository;
import com.lexsoft.fizionova.repository.PatientRepository;
import com.lexsoft.fizionova.repository.model.Adress;
import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.repository.model.Employee;
import com.lexsoft.fizionova.repository.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maschietto on 2/16/17.
 */
@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    AdressRepository adressRepository;

    @Transactional
    public ResponseEntity getPatients(String name, String lastname, String phone) {
         if (name != null || lastname != null || phone != null) {
            List<Patient> patients = patientRepository.getPatients(name, lastname, phone);
            if (patients != null && !patients.isEmpty()) {
                return getAllPatients(patients);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } else {
            List<Patient> patients = patientRepository.getPatients(null, null, null);
            if (null == patients || patients.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return getAllPatients(patients);
        }

    }

    public ResponseEntity getPatientById(Integer id) {
        Patient patient = patientRepository.getPatientById(id);
        if (patient != null) {
            Adress adress = adressRepository.getAdressById(patient.getAdressId());
            patient.setAdress(adress);
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @Transactional
    public ResponseEntity savePatient(Patient patient) throws BussinesException {
        List<Patient> patients = patientRepository.getPatients(patient.getName(), patient.getLastname(), patient.getPhone1());
        if (patient.getEmployeeId() != null && null == employeeRepository.findById(patient.getEmployeeId())) {
            throw new BussinesException("Employee does not exist in database!");
        }
        if (patients.isEmpty()) {
            patient.setAdressId(null);
            if (patient.getAdress() != null) {
                adressRepository.insertAdress(patient.getAdress());
                Integer id = adressRepository.getLastInsertedAdressId();
                patient.setAdressId(id);
            }
            patientRepository.savePatient(patient);
            Patient pat = patientRepository.getLastInsertedPatientIdByEmployeeid(patient.getEmployeeId());
            return ResponseEntity.status(HttpStatus.CREATED).body(pat);
        } else {
            throw new BussinesException("Patient allready exists in database. ");
        }
    }

    @Transactional
    public ResponseEntity updatePatient(Patient patient) throws BussinesException {
        Patient patients = patientRepository.getPatientById(patient.getIdPatient());
        if (patients != null) {
            if (patient.getEmployeeId() != null && null == employeeRepository.findById(patient.getEmployeeId())) {
                throw new BussinesException("Employee does not exist in database!");
            }
            if(patient.getAdress() != null) {
                Adress adress = adressRepository.getAdressById(patient.getAdress().getAdressId());

                Integer lastInsertAdressId = null;
                if (adress != null) {
                    adressRepository.updateAdress(patient.getAdress());
                } else {
                    adressRepository.insertAdress(patient.getAdress());
                    lastInsertAdressId = adressRepository.getLastInsertedAdressId();
                    patient.setAdressId(lastInsertAdressId);
                }
            }
            patientRepository.updatePatient(patient);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    private PatientWrapper getAllPatientDependencies(Integer patientId) {

        Patient patient = patientRepository.getPatientById(patientId);
        Employee employee = employeeRepository.findById(patient.getEmployeeId());
        Adress adress = adressRepository.getAdressById(patient.getAdressId());
        List<Document> listOfDocs = documentRepository.findDocumentsByParam(patient.getIdPatient(), null, null);
        patient.setAdress(adress);
        PatientWrapper patientWrapper = new PatientWrapper();
        patientWrapper.setPatient(patient);
        patientWrapper.setEmployee(employee);
        patientWrapper.setListOfDocuments(listOfDocs);
        return patientWrapper;

    }

    private ResponseEntity getAllPatients(List<Patient> patients) {
        List<PatientWrapper> listOfPatients = new ArrayList<>();
        for (Patient p : patients) {
            PatientWrapper wrapper = getAllPatientDependencies(p.getIdPatient());
            listOfPatients.add(wrapper);
        }
        return ResponseEntity.ok(listOfPatients);
    }

}
