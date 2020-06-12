package com.lexsoft.fizionova.model.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lexsoft.fizionova.repository.model.Employee;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeWrapper {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
