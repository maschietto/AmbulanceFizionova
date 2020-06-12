package com.lexsoft.fizionova.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.repository.model.Employee;
import com.lexsoft.fizionova.repository.model.Patient;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientWrapper {

    private Patient patient;
    private Employee employee;
    private List<Document> listOfDocuments;


    public Employee getEmployee() {
        return employee;
    }

    public List<Document> getListOfDocuments() {
        return listOfDocuments;
    }

    public void setListOfDocuments(List<Document> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
