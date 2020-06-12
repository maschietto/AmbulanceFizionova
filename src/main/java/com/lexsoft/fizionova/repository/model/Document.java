package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Maschietto on 2/14/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document {

    private Integer documentId;
    private String diagnose;
    private String functionalDiagnose;
    private String description;
    private String skeletImagePath;
    private String therapyDetails;
    private String therapyPurpose;
    private String therapyPlan;
    private String therapyMarks;
    private String therapyConclusion;
    private Integer idPatient;
    private String registerNumber;
    private Integer idEmployee;
    private Timestamp createDate;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    private List<Therapy> terapies;

    public List<Therapy> getTerapies() {
        return terapies;
    }

    public void setTerapies(List<Therapy> terapies) {
        this.terapies = terapies;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getFunctionalDiagnose() {
        return functionalDiagnose;
    }

    public void setFunctionalDiagnose(String functionalDiagnose) {
        this.functionalDiagnose = functionalDiagnose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkeletImagePath() {
        return skeletImagePath;
    }

    public void setSkeletImagePath(String skeletImagePath) {
        this.skeletImagePath = skeletImagePath;
    }

    public String getTherapyDetails() {
        return therapyDetails;
    }

    public void setTherapyDetails(String therapyDetails) {
        this.therapyDetails = therapyDetails;
    }

    public String getTherapyPurpose() {
        return therapyPurpose;
    }

    public void setTherapyPurpose(String therapyPurpose) {
        this.therapyPurpose = therapyPurpose;
    }

    public String getTherapyPlan() {
        return therapyPlan;
    }

    public void setTherapyPlan(String therapyPlan) {
        this.therapyPlan = therapyPlan;
    }

    public String getTherapyMarks() {
        return therapyMarks;
    }

    public void setTherapyMarks(String therapyMarks) {
        this.therapyMarks = therapyMarks;
    }

    public String getTherapyConclusion() {
        return therapyConclusion;
    }

    public void setTherapyConclusion(String therapyConclusion) {
        this.therapyConclusion = therapyConclusion;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }
}
