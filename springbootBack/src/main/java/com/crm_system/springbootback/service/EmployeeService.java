package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> selectEmployeePage(QueryDTO queryDTO);
    public Integer addEmployee(RegisterDTO registerDTO);
    public Integer updateEmployee(Employee employee);
    public Integer deleteEmployee(Integer id);
    public void batchDelete(List<Integer> ids);
    public Employee selectOne(RegisterDTO registerDTO);
    public Employee findEmployById(int parseInt);
    void updatePerformance(String judged_people, double performance);
    Object addEmployee(Employee employee);
    Integer selectNum(String keyWord);
    List<Double> getPerformance();
    List<String> getUsername();
}
