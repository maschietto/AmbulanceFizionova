package com.lexsoft.fizionova.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import com.lexsoft.fizionova.repository.model.Therapy;

import java.util.List;

/**
 * Created by Maschietto on 2/26/17.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TherapyWrapperDoc {

    Therapy therapy;
    List<EnumTherapyType> enumTherapyTypeList;

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public List<EnumTherapyType> getEnumTherapyTypeList() {
        return enumTherapyTypeList;
    }

    public void setEnumTherapyTypeList(List<EnumTherapyType> enumTherapyTypeList) {
        this.enumTherapyTypeList = enumTherapyTypeList;
    }
}
