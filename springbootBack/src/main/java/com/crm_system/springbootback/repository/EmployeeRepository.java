package com.crm_system.springbootback.repository;

import com.crm_system.springbootback.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    default Employee findEmployeesByUsernameAndPassword(String username, String password){
        Employee employee=new Employee();
        employee.setUsername(username);
        employee.setPassword(password);
        return employee;
    }
}
