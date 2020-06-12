package com.lexsoft.fizionova.repository.model.complexmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class TherapyComplex {

    private Integer idTherapy;
    private String startTherapyTime;
    private Integer idPatient;

    private String name;
    private String lastname;
    private String phone1;

    private List<TherapyComplex> therapy;

    public List<TherapyComplex> getTherapy() {
        return therapy;
    }

    public void setTherapy(List<TherapyComplex> therapy) {
        this.therapy = therapy;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdTherapy() {
        return idTherapy;
    }

    public void setIdTherapy(Integer idTherapy) {
        this.idTherapy = idTherapy;
    }

    public String getStartTherapyTime() {
        return startTherapyTime;
    }

    public void setStartTherapyTime(String startTherapyTime) {
        this.startTherapyTime = startTherapyTime;
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
}
