package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnumDiagnoseType {

    private Integer enumDiagnoseTypeId;
    private String diagnoseName;

    public Integer getEnumDiagnoseTypeId() {
        return enumDiagnoseTypeId;
    }

    public void setEnumDiagnoseTypeId(Integer enumDiagnoseTypeId) {
        this.enumDiagnoseTypeId = enumDiagnoseTypeId;
    }

    public String getDiagnoseName() {
        return diagnoseName;
    }

    public void setDiagnoseName(String diagnoseName) {
        this.diagnoseName = diagnoseName;
    }
}
