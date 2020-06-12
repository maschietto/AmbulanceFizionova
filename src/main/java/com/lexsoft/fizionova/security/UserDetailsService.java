package com.lexsoft.fizionova.security;

import com.lexsoft.fizionova.repository.EmployeeRepository;
import com.lexsoft.fizionova.repository.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        System.out.println(login);
        Employee employee = employeeRepository.getEmployee(login, null);

        if (employee != null) {
            System.out.println(employee.getRoleName());
            System.out.println(employee.getUsername());
            Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(employee.getRoleName());
            grantedAuthorities.add(grantedAuthority);
            return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
        } else {
            System.out.println("returned null for not know why!");
            return null;
        }


    }

}
