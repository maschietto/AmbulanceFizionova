package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Adress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AdressMapper {

    Adress findAdressById(@Param("adressId") Integer adressId);

    int insert(@Param("streetName") String streetName, @Param("streetNumber") String streetNumber);

    void update(@Param("streetName") String streetName,
                @Param("streetNumber") String streetNumber,
                @Param("adressId") Integer adressId);

    Adress selectLastInsertAdress();
}
