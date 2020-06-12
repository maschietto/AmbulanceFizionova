package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Document;
import com.lexsoft.fizionova.service.DocumentService;
import com.lexsoft.fizionova.validator.DocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Maschietto on 2/11/17.
 */
@Controller
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    DocumentService documentService;
    @Autowired
    DocumentValidator documentValidator;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveDocument(@RequestBody(required = true) Document document) throws BussinesException {
        documentValidator.validateDocumentRequestBody(document);
        return documentService.saveDocument(document);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getDocumentByParams(@RequestParam(value = "patientId",required = false) String patientId,
                                              @RequestParam(value = "documentId",required = false) String documentId,
                                              @RequestParam(value = "registerNumber", required = false) String registerNumber) throws BussinesException, ParseException {
        documentValidator.validateNumericRequestParam((patientId), "patientId");
        documentValidator.validateNumericRequestParam((documentId), "documentId");
        documentValidator.validateAlphaNumericRequestParam(registerNumber, "registerNumber");
        return documentService.findDocumentsByParam(patientId, documentId, registerNumber);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateEmployeeById(@RequestBody(required = true) Document document) throws BussinesException {
        documentValidator.validateDocumentRequestBody(document);
        return documentService.updateDocument(document);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{documentId}")
    public ResponseEntity getDocumentById(@PathVariable("documentId") Integer documentId) throws BussinesException, ParseException {
        documentValidator.validateNumericRequestParam(String.valueOf(documentId), "documentId");
        return documentService.findDocumentById(documentId);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/docWrapp")
    public ResponseEntity getDocumentWrapper(@RequestParam("documentId") Integer documentId) throws BussinesException, ParseException {
        documentValidator.validateNumericRequestParam(String.valueOf(documentId), "documentId");
        return documentService.findDocumentWrapperById(documentId);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteDocumentById(@RequestParam("documentId") Integer documentId) throws BussinesException, ParseException {
        documentValidator.validateNumericRequestParam(String.valueOf(documentId), "documentId");
        return documentService.deleteDocumentById(documentId);
    }


    @ExceptionHandler({BussinesException.class,ParseException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }


}
