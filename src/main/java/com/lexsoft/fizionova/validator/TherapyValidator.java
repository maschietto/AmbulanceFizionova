package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Therapy;
import org.springframework.stereotype.Component;

/**
 * Created by Maschietto on 2/16/17.
 */
@Component()
public class TherapyValidator extends AbstractValidator{

    public void validateTherapyRequestBody(Therapy therapy) throws BussinesException {
        validateNumeric(String.valueOf(therapy.getIdTherapy()),"therapyId");
        validateNumeric(String.valueOf(therapy.getDocumentId()),"documentId");
        validateNumeric(String.valueOf(therapy.getCreateEmployeeId()),"createEmplpyeeId");
        validateNumeric(String.valueOf(therapy.getVerifiedEmployeeId()), "verifiedEmployeeId");
        validateDate(String.valueOf(therapy.getStartTherapyTime()), "startTherapyTime");

    }


}
