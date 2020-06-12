package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Therapy {

    private Integer idTherapy;
    private Integer documentId;
    private String startTherapyTime;
    private Integer createEmployeeId;
    private Integer verifiedEmployeeId;
    private String therapyTypeIds;
    private Integer idPatient;
    private Boolean isVerified;
    private String dateCreate;

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    private List<Therapy> therapy;

    public List<Therapy> getTherapy() {
        return therapy;
    }

    public void setTherapy(List<Therapy> therapy) {
        this.therapy = therapy;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getTherapyTypeIds() {
        return therapyTypeIds;
    }

    public void setTherapyTypeIds(String therapyTypeIds) {
        this.therapyTypeIds = therapyTypeIds;
    }

    public Integer getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(Integer createEmployeeId) {
        this.createEmployeeId = createEmployeeId;
    }

    public Integer getVerifiedEmployeeId() {
        return verifiedEmployeeId;
    }

    public void setVerifiedEmployeeId(Integer verifiedEmployeeId) {
        this.verifiedEmployeeId = verifiedEmployeeId;
    }

    public Integer getIdTherapy() {
        return idTherapy;
    }

    public void setIdTherapy(Integer idTherapy) {
        this.idTherapy = idTherapy;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getStartTherapyTime() {
        return startTherapyTime;
    }

    public void setStartTherapyTime(String startTherapyTime) {
        this.startTherapyTime = startTherapyTime;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }
}
