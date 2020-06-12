package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.EnumTherapyType;
import org.springframework.stereotype.Component;

/**
 * Created by Maschietto on 2/16/17.
 */
@Component()
public class EnumTherapyTypeValidator extends AbstractValidator{

    public void validateEnumTherapyRequestBody(EnumTherapyType  enumTherapyType) throws BussinesException {
        validateAlpha(enumTherapyType.getEnumTherapyTypeName(), "therapyTypeName");
        validateNumeric(String.valueOf(enumTherapyType.getEnumTherapyTypeId()), "enumTherapyTypeId");


    }



}
