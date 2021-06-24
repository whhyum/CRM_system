package com.crm_system.springbootback.service;

import com.crm_system.springbootback.dto.EmployeeDTO;
import com.crm_system.springbootback.dto.UserDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.User;

import java.util.List;

public interface EmployeeService {
//    public IPage<User> selectUserPage(QueryDTO queryDTO);
    public Integer addEmployee(EmployeeDTO employeeDTO);
    public Integer updateEmployee(Employee employee);
    public Integer deleteEmployee(Integer id);
    public void batchDelete(List<Integer> ids);
    public Employee selectOne(EmployeeDTO employeeDTO);
    public Employee findEmployById(int parseInt);
}
