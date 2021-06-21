package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeHander {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping(value ="/findAll")
    public Employee findAll(String username,String password){
        return employeeRepository.findEmployeesByUsernameAndPassword(username,password);
    }
}
