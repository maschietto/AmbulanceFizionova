package com.lexsoft.fizionova.controller;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.EmployeeRepository;
import com.lexsoft.fizionova.repository.model.Employee;
import com.lexsoft.fizionova.service.EmployeeService;
import com.lexsoft.fizionova.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Maschietto on 2/11/17.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeValidator employeeValidator;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveEmployee(@RequestBody(required = true) Employee employee) throws BussinesException {
        employeeValidator.validateEmployeeRequestBody(employee);
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getByNameOfEmployee(@RequestParam(value = "username", required = false) String username,
                                              @RequestParam(value = "password", required = false) String password) throws BussinesException {
        if(username != null || password != null){
        if (username != null) employeeValidator.validateAlphaNumericOneParam(username, "username");
        if (password != null) employeeValidator.validateAlphaNumericOneParam(password, "password");
        return employeeService.findEmployees(username, password);
        }else {
            return employeeService.findAllEmployees();
        }

    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateEmployeeById(@RequestBody(required = true) Employee employee) throws BussinesException {
        employeeValidator.validateMandatoryOneParam(employee.getIdEmployee(),"employeeId");
        employeeValidator.validateAlphaNumericOneParam(String.valueOf(employee.getIdEmployee()),"employeeId");
        employeeValidator.validateEmployeeRequestBody(employee);
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id) throws BussinesException {
        employeeValidator.validateMandatoryOneParam(String.valueOf(id),"id");
        employeeValidator.validateNumericOneParam(String.valueOf(id), "id");
        return employeeService.findEmployeeById(id);
    }


    @ExceptionHandler({BussinesException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }


}
