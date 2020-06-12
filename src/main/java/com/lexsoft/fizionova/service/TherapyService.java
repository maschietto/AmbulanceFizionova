package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.model.wrapper.TherapyWrapper;
import com.lexsoft.fizionova.repository.DocumentRepository;
import com.lexsoft.fizionova.repository.FirstExamRepository;
import com.lexsoft.fizionova.repository.PatientRepository;
import com.lexsoft.fizionova.repository.TherapyRepository;
import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.repository.model.Patient;
import com.lexsoft.fizionova.repository.model.Therapy;
import com.lexsoft.fizionova.repository.model.complexmodel.TherapyComplex;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Maschietto on 2/16/17.
 */
@Service
public class TherapyService {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    TherapyRepository therapyRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    FirstExamRepository firstExamRepository;

    public ResponseEntity findTherapyByParam(String documentId) throws ParseException {
        List<Therapy> therapyList = therapyRepository.findTherapyByParams(Integer.valueOf(documentId));
        if (therapyList != null) {
            return ResponseEntity.ok(therapyList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    public ResponseEntity findById(Integer id) throws BussinesException {
        Therapy therapy = therapyRepository.findTherapyById(id);

        if (therapy != null) {
            return ResponseEntity.ok(therapy);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @Transactional
    public ResponseEntity saveTherapy(Therapy therapy) throws BussinesException, ParseException {
        Therapy foundTherapy = therapyRepository.findTherapyById(therapy.getIdTherapy());
        if (foundTherapy != null) {
            throw new BussinesException("Therapy allready exists in database. ");
        } else {
            therapyRepository.insertTherapy(therapy);
            Therapy therapy1 = therapyRepository.findLastInsertedIdTherapy(therapy.getIdPatient());
            return ResponseEntity.status(HttpStatus.CREATED).body(therapy1);
        }
    }

    @Transactional
    public ResponseEntity updateTherapy(Therapy therapy) throws BussinesException, ParseException {
        Therapy foundTherapy = therapyRepository.findTherapyById(therapy.getIdTherapy());
        if (foundTherapy != null) {
            therapyRepository.updateTherapy(therapy);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity deleteTherapy(Integer id) throws BussinesException {
        Therapy foundTherapy = therapyRepository.findTherapyById(id);
        if (foundTherapy != null) {
            therapyRepository.deleteTherapy(id);
            firstExamRepository.deleteByTherapyId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity findByDateOfExam(String date) throws BussinesException, ParseException {
        System.out.println(date);
        Date dateFrom = SDF.parse(date);
        dateFrom = DateUtils.setHours(dateFrom, 00);
        dateFrom = DateUtils.setMinutes(dateFrom, 00);
        dateFrom = DateUtils.setSeconds(dateFrom, 00);
        Date dateTo = dateFrom;
        dateTo = DateUtils.addDays(dateTo, 1);
        System.out.println(dateFrom);
        System.out.println(dateTo);
        List<TherapyComplex> therapiesOnDay = therapyRepository.findTherapiesBeewteenTwoDates(dateFrom, dateTo);
        if (therapiesOnDay != null && !therapiesOnDay.isEmpty()) {
            return ResponseEntity.ok(therapiesOnDay);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity findTherapiesByPatientId(Integer idPatient) {
        List<Therapy> therapyList = therapyRepository.findTherapiesByPatientId(idPatient);
        Patient patient = patientRepository.getPatientById(idPatient);

        TherapyWrapper therapyWrapper = new TherapyWrapper();
        therapyWrapper.setTherapy(therapyList);
        therapyWrapper.setPatient(patient);
        return ResponseEntity.ok(therapyWrapper);

    }

    @Transactional
    public ResponseEntity updateLastNonVerifiedTherapy(Therapy therapy) throws ParseException {
        List<Document> documents = documentRepository.findDocumentsByParam(therapy.getIdPatient(),null,null);

        if(documents!=null || !documents.isEmpty()) {
            Therapy lastNonModifiedTherapy = therapyRepository.findLastNotModifiedTherapyFromDoc(documents.get(0).getDocumentId());
            lastNonModifiedTherapy.setStartTherapyTime(therapy.getStartTherapyTime());
            therapyRepository.updateTherapy(lastNonModifiedTherapy);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
