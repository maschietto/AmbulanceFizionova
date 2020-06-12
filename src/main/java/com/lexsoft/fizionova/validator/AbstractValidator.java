package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maschietto on 2/16/17.
 */
public abstract class AbstractValidator {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String ALPHA_UNDERSCORE = "^[a-zA-Z0-9_]*$";

    protected void validateAlphaNumeric(String content, String fieldName) throws BussinesException {
        if (content != null && !StringUtils.isAlphanumeric(content)) {
            throw new BussinesException("Content of field " + fieldName + " must contain only numbers and letters.");
        }
    }

    protected void validateNumeric(String content, String fieldName) throws BussinesException {
        if (content != null && !StringUtils.isNumeric(content)) {
            throw new BussinesException("Content of field " + fieldName + " must contain only numbers.");
        }
    }

    protected void validateAlpha(String content, String fieldName) throws BussinesException {
        if (content != null && !StringUtils.isAlpha(content)) {
            throw new BussinesException("Content of field " + fieldName + " must contain only letters.");
        }
    }

    protected void validateMandatory(String content, String fieldName) throws BussinesException {
        if (null == content || StringUtils.isBlank(content)) {
            throw new BussinesException("Field " + fieldName + " is mandatory. This field must not be empty as well. ");
        }
    }

    protected void validateEmail(String content, String fieldName) throws BussinesException {
        if(content != null && !content.isEmpty()){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(content);
        if (!matcher.matches()) {
            throw new BussinesException("Email format is not valid for field " + fieldName + " .");
        }
    }}

    protected void validateBoolean(String content, String fieldName) throws BussinesException {
        try {
            Boolean.valueOf(content);
        } catch (ClassCastException e) {
            throw new BussinesException("Content of field " + fieldName + " must be true or false. ");
        }
    }

    protected void validateStringWithUnderscore(String content, String fieldName) throws BussinesException {
        Pattern pattern = Pattern.compile(ALPHA_UNDERSCORE);
        Matcher matcher = pattern.matcher(content);
        if (!matcher.matches()) {
            throw new BussinesException("Format is not valid for field " + fieldName + " .");
        }

    }

    protected void validateDate(String content, String fieldName) throws BussinesException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(content);

        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(content);
        } catch (ParseException e) {
            throw new BussinesException("Date format is not valid " + fieldName + " .");
        }
    }


    protected void validateMandatoryInteger(Integer content, String field) throws BussinesException {
        if(content == null){
         throw  new BussinesException("Field " + field + " must be numeric value.");
        }
    }



}
