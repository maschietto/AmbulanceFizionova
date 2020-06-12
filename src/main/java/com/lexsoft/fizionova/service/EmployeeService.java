package com.lexsoft.fizionova.service;

import com.lexsoft.fizionova.exception.BussinesException;
import com.lexsoft.fizionova.repository.EmployeeRepository;
import com.lexsoft.fizionova.repository.model.Employee;
import com.lexsoft.fizionova.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Maschietto on 2/16/17.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeValidator employeeValidator;

    @Transactional
    public ResponseEntity findEmployees(String username, String password) throws BussinesException {
        if (username != null || password != null) {
            Employee employee = employeeRepository.getEmployee(username, password);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity findAllEmployees() throws BussinesException {
        List<Employee> allEmployees = employeeRepository.findAllEmployees();
        if (allEmployees != null && !allEmployees.isEmpty()) {
            return ResponseEntity.ok(allEmployees);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity saveEmployee(Employee employee) throws BussinesException {
        Employee employeeLoc = employeeRepository.getEmployee(employee.getUsername(), null);
        if (employeeLoc != null) {
            throw new BussinesException("User with this username allready exists in database.");
        }
        employeeLoc = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
        if (employeeLoc != null) {
            throw new BussinesException("User with this personal number allready exists in database.");
        }
        employee.setRoleName("ROLE_ANONYMOUS");
        employeeRepository.insertEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee.getIdEmployee());
    }

    @Transactional
    public ResponseEntity updateEmployee(Employee employee) throws BussinesException {
        Employee employeeLoc = employeeRepository.findById(employee.getIdEmployee());
        if (employeeLoc != null) {
            employeeRepository.updateEmployee(employee);
            return ResponseEntity.ok().build();
        } else {
            throw new BussinesException("Employee with this id does not exists in database.");
        }
    }

    public ResponseEntity findEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
