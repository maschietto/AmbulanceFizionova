package com.lexsoft.fizionova.repository;

import com.lexsoft.fizionova.repository.mapper.EmployeeMapper;
import com.lexsoft.fizionova.repository.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Maschietto on 2/11/17.
 */
@Repository
public class EmployeeRepository {

    @Autowired
     EmployeeMapper employeeMapper;


    public int insertEmployee(Employee employee){
       return employeeMapper.insert(employee.getUsername(), employee.getPassword(), employee.getName(), employee.getLastname(),employee.getMiddlename(),
                employee.getPersonalId(), employee.getEmail(), employee.getAdressId(), employee.getAdmin(), employee.getVerifyTherapy() ,employee.getCreateDoc(),
                employee.getViewDoc(), employee.getPhone1(), employee.getPhone2(), employee.getPathToEmployeeImage(), employee.getForeigner(), employee.getRoleName(), employee.getJobTitle());

    }

    public Employee getEmployee(String username, String password){
        Employee employee =  employeeMapper.findByName(username, password, null);
        return employee;
    }

    public Employee getEmployeeByPersonalId(String personalId){
        Employee employee =  employeeMapper.findByName(null, null, personalId);
        return employee;
    }

    public void updateEmployee(Employee employee){
        employeeMapper.update(employee.getIdEmployee(), employee.getPassword(), employee.getEmail(), employee.getAdressId(), employee.getAdmin(), employee.getVerifyTherapy(),employee.getCreateDoc(),
                employee.getViewDoc(), employee.getPhone1(), employee.getPhone2(), employee.getPathToEmployeeImage(), employee.getForeigner(), employee.getJobTitle(), employee.getRoleName());

    }

    public List<Employee> findAllEmployees(){
        List<Employee> employeeList;
         employeeList = employeeMapper.findAllEmployee();
        return  employeeList;
    }

    public Employee findById(Integer idEmployee){
        Employee employee = employeeMapper.findById(idEmployee);
        return employee;
    }


}
