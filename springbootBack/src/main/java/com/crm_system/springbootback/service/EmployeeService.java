package com.crm_system.springbootback.service;

import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.entity.Employee;

import java.util.List;

public interface EmployeeService {
//    public IPage<User> selectUserPage(QueryDTO queryDTO);
    public Integer addEmployee(RegisterDTO registerDTO);
    public Integer updateEmployee(Employee employee);
    public Integer deleteEmployee(Integer id);
    public void batchDelete(List<Integer> ids);
    public Employee selectOne(RegisterDTO registerDTO);
    public Employee findEmployById(int parseInt);
    void updatePerformance(String judged_people, double performance);
}
