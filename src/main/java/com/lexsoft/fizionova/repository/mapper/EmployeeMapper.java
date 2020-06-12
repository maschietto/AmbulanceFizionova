package com.lexsoft.fizionova.repository.mapper;

import com.lexsoft.fizionova.repository.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EmployeeMapper {

    List<Employee> findAllEmployee();
    Employee findByName(@Param("username") String username,
                        @Param("password") String password,
                        @Param("personalId") String personalId);

    Employee findById(@Param("idEmployee") Integer employeeId);

    int insert(@Param("username") String username, @Param("password") String password, @Param("name") String name,
               @Param("lastname") String lastname,
               @Param("middlename") String middlename, @Param("personalId") String perosnalId,
               @Param("email") String email, @Param("adressId") Integer adressId,
               @Param("isAdmin") Boolean isAdmin, @Param("verifyTherapy") Boolean verifyTherapy,
               @Param("createDoc") Boolean createDoc, @Param("viewDoc") Boolean viewDoc,
               @Param("phone1") String phone1, @Param("phone2") String phone2, @Param("pathToEmployeeImage") String pathToEmployeeImage,
               @Param("isForeigner") Boolean isForeigner,@Param("roleName") String roleName, @Param("jobTitle") String jobTitle);

    void update(@Param("idEmployee") Integer employeeId, @Param("password") String password,
                @Param("email") String email, @Param("adressId") Integer adressId,
                @Param("isAdmin") Boolean isAdmin, @Param("verifyTherapy") Boolean verifyTherapy,
                @Param("createDoc") Boolean createDoc, @Param("viewDoc") Boolean viewDoc,
                @Param("phone1") String phone1, @Param("phone2") String phone2, @Param("pathToEmployeeImage") String pathToEmployeeImage,
                @Param("isForeigner") Boolean isForeigner, @Param("jobTitle") String jobTitle, @Param("roleName") String roleName);

}
