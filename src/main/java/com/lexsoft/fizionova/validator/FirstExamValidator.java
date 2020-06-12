package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.FirstExam;
import org.springframework.stereotype.Component;

/**
 * Created by Maschietto on 2/16/17.
 */
@Component()
public class FirstExamValidator extends AbstractValidator {

    public void validateFirstExamRequestBody(FirstExam firstExam) throws BussinesException {

        validateNumeric(String.valueOf(firstExam.getIdFirstExam()), "firstExamId");
        validateAlpha(firstExam.getName(), "name");
        validateAlpha(firstExam.getLastname(), "lastname");
        validateNumeric(firstExam.getPhoneNumber(), "phoneNumber");
        validateDate(String.valueOf(firstExam.getExamStartTime()), "examStartTIme");
        validateMandatory(firstExam.getName(), "name");
        validateMandatory(firstExam.getLastname(), "lastname");
        validateMandatory(firstExam.getPhoneNumber(), "phoneNumber");
        validateMandatory(String.valueOf(firstExam.getExamStartTime()), "examStartTime");


    }


}
