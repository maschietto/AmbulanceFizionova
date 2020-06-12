package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnumTherapyType {

    private Integer enumTherapyTypeId;
    private String enumTherapyTypeName;

    public Integer getEnumTherapyTypeId() {
        return enumTherapyTypeId;
    }

    public void setEnumTherapyTypeId(Integer enumTherapyTypeId) {
        this.enumTherapyTypeId = enumTherapyTypeId;
    }

    public String getEnumTherapyTypeName() {
        return enumTherapyTypeName;
    }

    public void setEnumTherapyTypeName(String enumTherapyTypeName) {
        this.enumTherapyTypeName = enumTherapyTypeName;
    }
}
