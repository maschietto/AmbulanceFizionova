package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.FirstExamMapper;
import com.lexsoft.fizionova.repository.model.FirstExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public class FirstExamRepository {

    @Autowired
    FirstExamMapper firstExamMapper;


    public int insertFirstExam(FirstExam firstExam) {
        return firstExamMapper.insert(firstExam.getName(), firstExam.getLastname(), firstExam.getPhoneNumber(), firstExam.getExamStartTime(), firstExam.getIdPatient(), firstExam.getIdTherapy());
    }

    public FirstExam getFirstExamById(Integer id) {
        FirstExam firstExam = firstExamMapper.findFirstExam(id);
        return firstExam;
    }

    public void updateFirstExam(FirstExam firstExam) {
        firstExamMapper.update(firstExam.getName(), firstExam.getLastname(), firstExam.getPhoneNumber(), firstExam.getExamStartTime(), firstExam.getIdFirstExam(), firstExam.getIdPatient(),firstExam.getIdTherapy());
    }

    public void delete(Integer id) {
        firstExamMapper.deleteFirstExam(id);
    }

    public void deleteByTherapyId(Integer idTherapy) {
        firstExamMapper.deleteFirstExamByTherapyId(idTherapy);
    }

    public List<FirstExam> findByParam(String name, String lastname, String phoneNumber, Integer idTherapy){
        return firstExamMapper.findByParam(name,lastname,phoneNumber,idTherapy);
    }

    public List<FirstExam> findExamsByDate(Date dateFrom , Date dateTo){
        return firstExamMapper.findFirstExamsByDate(dateFrom, dateTo);
    }
}