package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.model.Employee;
import com.lexsoft.fizionova.service.EmailService;
import com.lexsoft.fizionova.service.EmployeeService;
import com.lexsoft.fizionova.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Maschietto on 2/14/17.
 */
@Controller
@RequestMapping("/register")
public class RegisterUserController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmailService emailService;
    @Autowired
    EmployeeValidator employeeValidator;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveFirstExam(@RequestBody Employee employee) throws BussinesException, ParseException, MessagingException {
        employeeValidator.validateEmployeeRequestBody(employee);
        //emailService.sendEmail(employee);
        return employeeService.saveEmployee(employee);
    }


    @ExceptionHandler({BussinesException.class,ParseException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
