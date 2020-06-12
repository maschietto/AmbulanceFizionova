package com.lexsoft.fizionova.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lexsoft.fizionova.repository.model.Patient;
import com.lexsoft.fizionova.repository.model.Therapy;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TherapyWrapper {

    private List<Therapy> therapy;
    private Patient patient;


    public List<Therapy> getTherapy() {
        return therapy;
    }

    public void setTherapy(List<Therapy> therapy) {
        this.therapy = therapy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
