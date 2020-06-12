package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Adress;
import org.springframework.stereotype.Component;

/**
 * Created by Maschietto on 2/16/17.
 */
@Component()
public class AdressValidator extends AbstractValidator{

    public void validateAdressRequestBody(Adress adress) throws BussinesException {
        if(adress != null) {
            validateMandatory(adress.getStreetName(),"streetName");
            validateMandatory(adress.getStreetNumber(),"streetNumber");
        }
    }

}
