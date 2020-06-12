package com.lexsoft.fizionova.model.wrapper.request;

import com.lexsoft.fizionova.repository.model.Adress;
import com.lexsoft.fizionova.repository.model.Patient;

/**
 * Created by Maschietto on 2/18/17.
 */
public class RequestPatient {

    private Patient patient;
    private Adress adress;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
