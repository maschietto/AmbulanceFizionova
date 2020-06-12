package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Employee;
import org.springframework.stereotype.Component;

/**
 * Created by Maschietto on 2/16/17.
 */
@Component()
public class EmployeeValidator extends AbstractValidator{

    public void validateEmployeeRequestBody(Employee employee) throws BussinesException {
        validateMandatory(employee.getUsername(), "username");
        validateMandatory(employee.getLastname(), "lastname");
        validateMandatory(employee.getName(),"name");
        validateMandatory(employee.getRoleName(),"Role name");
        validateMandatory(employee.getJobTitle(),"Job title");
        validateMandatory(employee.getEmail(),"Email");
        validateMandatory(employee.getPhone1(),"Phone");
        validateMandatory(employee.getPassword(),"Password");
        validateNumeric(employee.getPersonalId(),"personalId");
        validateAlpha(employee.getName(),"name");
        validateAlpha(employee.getLastname(), "lastname");
        validateAlpha(employee.getMiddlename(), "middelname");
        validateEmail(employee.getEmail(), "email");
        validateAlphaNumeric(employee.getPassword(), "password");
        validateAlphaNumeric(employee.getUsername(), "useraname");
        validateNumeric(employee.getPhone1(), "phone1");
        validateNumeric(employee.getPhone2(), "phone2");
        validateStringWithUnderscore(employee.getRoleName(), "roleName");
        //validateNumeric(String.valueOf(employee.getAdressId()), "adressId");
        validateBoolean(String.valueOf(employee.getAdmin()), "admin");
        validateBoolean(String.valueOf(employee.getVerifyTherapy()), "verifyTherapy");
        validateBoolean(String.valueOf(employee.getForeigner()), "foreigner");
        validateBoolean(String.valueOf(employee.getCreateDoc()), "createDoc");
        validateBoolean(String.valueOf(employee.getViewDoc()), "viewDoc");
    }

    public void validateAlphaNumericOneParam(String content, String param) throws BussinesException {
        validateAlphaNumeric(content, param);
    }

    public void validateNumericOneParam(String content, String param) throws BussinesException{
        validateNumeric(content, param);
    }

    public void validateMandatoryOneParam(String content, String param) throws BussinesException{
        validateMandatory(content, param);
    }

    public void validateMandatoryOneParam(Integer content, String param) throws BussinesException{
        validateMandatoryInteger(content, param);
    }


}
