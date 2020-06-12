package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Therapy;
import com.lexsoft.fizionova.service.TherapyService;
import com.lexsoft.fizionova.validator.TherapyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/therapies")
public class TherapyController {

    @Autowired
    TherapyService therapyService;
    @Autowired
    TherapyValidator patientValidator;

    //GET Therapy BY ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getTherapyById(@PathVariable(value = "id") Integer id) throws BussinesException {
        return therapyService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/idPatient")
    public ResponseEntity getTherapyByPatientId(@RequestParam(value = "id") Integer id) throws BussinesException {
        return therapyService.findTherapiesByPatientId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getTherapyByParams(@RequestParam("documentId") String id)
                                              throws BussinesException, java.text.ParseException {
        return therapyService.findTherapyByParam(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveTherapy(@RequestBody(required = true) Therapy therapy) throws BussinesException, java.text.ParseException {
        return therapyService.saveTherapy(therapy);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateTherapy(@RequestBody(required = true) Therapy therapy) throws BussinesException, java.text.ParseException {
        return therapyService.updateTherapy(therapy);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteTherapy(@PathVariable(value = "id") Integer id) throws BussinesException {
        return therapyService.deleteTherapy(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/date")
    public ResponseEntity findTherapiesByDay(@RequestParam(value = "dateFrom",required = true) String dateFrom ) throws BussinesException, java.text.ParseException {
        System.out.println(dateFrom);
        return therapyService.findByDateOfExam(dateFrom);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/scheduler")
    public ResponseEntity findTherapiesByDay(@RequestBody(required = true) Therapy therapy ) throws BussinesException, java.text.ParseException {
        return therapyService.updateLastNonVerifiedTherapy(therapy);
    }

    @ExceptionHandler({BussinesException.class, ParseException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
