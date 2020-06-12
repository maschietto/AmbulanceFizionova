package com.lexsoft.fizionova.repository.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Maschietto on 2/14/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adress {

    private Integer adressId;
    private String streetName;
    private String streetNumber;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
    public Integer getAdressId() {
        return adressId;
    }

    public void setAdressId(Integer adressId) {
        this.adressId = adressId;
    }



}
