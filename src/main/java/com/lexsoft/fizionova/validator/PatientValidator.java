package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Patient;
import org.springframework.stereotype.Component;


@Component("patientValidator")
public class PatientValidator extends AbstractValidator {

    public void validatePatientRequestBody(Patient patient) throws BussinesException {
        validateMandatory(patient.getName(), "name");
        validateMandatory(patient.getLastname(), "lastname");
        validateMandatory(patient.getMiddlename(), "middlename");
        validateMandatory(patient.getPhone1(), "phone1");
        validateMandatory(patient.getGender(), "gender");
       // validateMandatory(patient.getAge(), "age");
        validateMandatory(String.valueOf(patient.getEmployeeId()), "employeeId");
        validateNumeric(String.valueOf(patient.getEmployeeId()), "employeeId");
        validateAlpha(patient.getName(), "name");
        validateAlpha(patient.getLastname(), "lastname");
        validateAlpha(patient.getMiddlename(), "middelname");

        validateEmail(patient.getEmail(), "email");
        validateNumeric(patient.getPhone1(), "phone1");
        validateNumeric(patient.getPhone2(), "phone2");
        validateAlpha(patient.getJobTitle(), "jobTitle");
        validateNumeric(patient.getPersonalId(), "perosnalId");
        validateBoolean(patient.getGender(), "gender");
        validateNumeric(patient.getAge(), "age");
        validateBoolean(String.valueOf(patient.getForeigner()), "isForeigner");
    }

    public void validateAlphaParam(String content, String param) throws BussinesException {
        validateAlpha(content, param);
    }
    public void validateNumericParam(String content, String param) throws BussinesException{
        validateNumeric(content, param);
    }


}
