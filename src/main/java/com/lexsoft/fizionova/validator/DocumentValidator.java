package com.lexsoft.fizionova.validator;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Document;
import org.springframework.stereotype.Component;

@Component("documentValidator")
public class DocumentValidator extends AbstractValidator {

    public void validateDocumentRequestBody(Document document) throws BussinesException {
        if (document.getDocumentId() != null) validateNumeric(String.valueOf(document.getDocumentId()), "documentId");
        validateNumeric(String.valueOf(document.getIdPatient()), "patientId");
        validateAlphaNumeric(document.getRegisterNumber(), "registerNumber");
        validateNumeric(String.valueOf(document.getIdEmployee()), "idEmployee");

    }


    public void validateNumericRequestParam(String content, String fieldName) throws BussinesException {
            validateNumeric(content, fieldName);
    }


    public void validateAlphaNumericRequestParam(String content, String fieldName) throws BussinesException {
            validateAlphaNumeric(content, fieldName);
    }

}
