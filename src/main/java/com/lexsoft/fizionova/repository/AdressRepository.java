package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.AdressMapper;
import com.lexsoft.fizionova.repository.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Maschietto on 2/17/17.
 */
@Repository
public  class AdressRepository {

    @Autowired
    AdressMapper adressMapper;


    public int insertAdress(Adress adress) {
        return adressMapper.insert(adress.getStreetName(),adress.getStreetNumber());
    }

    public Adress getAdressById(Integer adressId) {
        if (adressId != null) {
            Adress adress = adressMapper.findAdressById(adressId);
            return adress;
        } else {
            return null;
        }
    }

    public void updateAdress(Adress adress) {
        adressMapper.update(adress.getStreetName(),adress.getStreetNumber(),adress.getAdressId());
    }

    public Integer getLastInsertedAdressId(){
        Adress adress = adressMapper.selectLastInsertAdress();
        return adress.getAdressId();
    }

}