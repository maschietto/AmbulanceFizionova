package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.FirstExamRepository;
import com.lexsoft.fizionova.repository.model.FirstExam;
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
public class FirstExamService {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    FirstExamRepository firstExamRepository;

    public ResponseEntity findById(Integer id) throws BussinesException {
        FirstExam firstExam = firstExamRepository.getFirstExamById(id);

        if (firstExam != null) {
            return ResponseEntity.ok(firstExam);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity findByDateOfExam(String date) throws BussinesException, ParseException {
        Date dateFrom = SDF.parse(date);
        dateFrom = DateUtils.setHours(dateFrom, 00);
        dateFrom = DateUtils.setMinutes(dateFrom,00);
        dateFrom = DateUtils.setSeconds(dateFrom,00);
        Date dateTo = dateFrom;
        dateTo = DateUtils.addDays(dateTo,1);
        List<FirstExam >firstExamsOnDay = firstExamRepository.findExamsByDate(dateFrom, dateTo);
        if(firstExamsOnDay != null && !firstExamsOnDay.isEmpty()) {
            return ResponseEntity.ok(firstExamsOnDay);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @Transactional
    public ResponseEntity saveFirstExam(FirstExam firstExam) throws BussinesException, ParseException {
        FirstExam firstExam1 = firstExamRepository.getFirstExamById(firstExam.getIdFirstExam());
        if (firstExam1 != null) {
            throw new BussinesException("First exam allready exists in database. ");
        } else {
            firstExamRepository.insertFirstExam(firstExam);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @Transactional
    public ResponseEntity updateFirstExam(FirstExam firstExam) throws BussinesException, ParseException {
        FirstExam firstExam1 = firstExamRepository.getFirstExamById(firstExam.getIdFirstExam());
        if (firstExam1 != null) {
            firstExamRepository.updateFirstExam(firstExam);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity deleteFirstExam(Integer id) throws BussinesException {
        FirstExam firstExam = firstExamRepository.getFirstExamById(id);
        if (firstExam != null) {
            firstExamRepository.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity findFirstExamByParam(String name, String lastname, String phoneNumber , Integer idTherapy){
       List<FirstExam> firstExam = firstExamRepository.findByParam(name,lastname, phoneNumber, idTherapy);
        if (firstExam != null){
            return ResponseEntity.ok(firstExam);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
