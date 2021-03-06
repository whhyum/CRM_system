package com.crm_system.springbootback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.mapper.EmployeeMapper;
import com.crm_system.springbootback.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectEmployeePage(QueryDTO queryDTO) {
        List<Employee> employees = employeeMapper.selectEmployeePage(queryDTO.getKeyword());
//        从第几条数据开始
        int firstIndex = (queryDTO.getPageNo() - 1) * queryDTO.getPageSize();
//        到第几条数据结束
        int lastIndex = queryDTO.getPageNo() * queryDTO.getPageSize();
        if(lastIndex>employees.size()){
            lastIndex=employees.size();
        }
        return employees.subList(firstIndex, lastIndex);
    }

    @Override
    public Integer addEmployee(RegisterDTO registerDTO) {
        Employee employee=new Employee(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getEmail(), registerDTO.getRole_id());
        return employeeMapper.insert(employee);
    }
    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateById(employee);
    }

    @Override
    public Integer deleteEmployee(Integer id) {
        return employeeMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        employeeMapper.deleteBatchIds(ids);
    }
    @Override
    public  Employee selectOne(RegisterDTO registerDTO){
        //通过登录名查询用户
        QueryWrapper<Employee> wrapper = new QueryWrapper();
        wrapper.eq("username", registerDTO.getUsername());
        Employee employee=employeeMapper.selectOne(wrapper);
        System.out.println(employee);
        return employee;
    }
    @Override
    public Employee findEmployById(int parseInt){
       Employee employee= employeeMapper.selectById(parseInt);
       return employee;
    }

    @Override
    public void updatePerformance(String judged_people, double performance) {
        employeeMapper.updatePerformance(judged_people,performance);
    }

    @Override
    public Object addEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public Integer selectNum(String keyWord) {
        return employeeMapper.selectNum(keyWord);
    }

    @Override
    public List<Double> getPerformance() {
        return employeeMapper.getPerformance();
    }

    @Override
    public List<String> getUsername() {
        return employeeMapper.getUsername();
    }
}
