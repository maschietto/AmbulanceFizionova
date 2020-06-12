package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.FirstExam;
import com.lexsoft.fizionova.service.FirstExamService;
import com.lexsoft.fizionova.validator.FirstExamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/exams")
public class FirstExamController {

    @Autowired
    FirstExamService firstExamService;
    @Autowired
    FirstExamValidator firstExamValidator;


    //  GET FirstExam BY NAME, LASTNAME AND PHONE
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getFirstExam(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "lastname", required = false) String lastname,
                                       @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                                       @RequestParam(value = "idTherapy", required = false)Integer idTherapy) throws BussinesException {
        return firstExamService.findFirstExamByParam(name, lastname, phoneNumber, idTherapy);
    }

    @RequestMapping(method=RequestMethod.GET, value = "/date")
    public ResponseEntity getFirstExamByDate(@RequestParam(value = "dateFrom", required=false) String dateFrom) throws BussinesException, ParseException {
        return firstExamService.findByDateOfExam(dateFrom);

    }


    //GET First exam BY ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getFirstExam(@PathVariable(value = "id") Integer id) throws BussinesException {
        return firstExamService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveFirstExam(@RequestBody FirstExam firstExam) throws BussinesException, ParseException {

        return firstExamService.saveFirstExam(firstExam);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateFirstExam(@RequestBody FirstExam firstExam) throws BussinesException, ParseException {
        return firstExamService.updateFirstExam(firstExam);
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public ResponseEntity deleteFirstExam(@PathVariable(value = "id") Integer id) throws BussinesException {
        return firstExamService.deleteFirstExam(id);
    }

    @ExceptionHandler({BussinesException.class,ParseException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
