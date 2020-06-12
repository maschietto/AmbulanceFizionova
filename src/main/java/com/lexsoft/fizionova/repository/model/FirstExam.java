package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FirstExam {

    private Integer idFirstExam;
    private String name;
    private String lastname;
    private String phoneNumber;
    private String examStartTime;
    private Integer idPatient;
    private Integer idTherapy;

    public Integer getIdTherapy() {
        return idTherapy;
    }

    public void setIdTherapy(Integer idTherapy) {
        this.idTherapy = idTherapy;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(String examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Integer getIdFirstExam() {
        return idFirstExam;
    }

    public void setIdFirstExam(Integer idFirstExam) {
        this.idFirstExam = idFirstExam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
