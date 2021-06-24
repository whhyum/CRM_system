package com.crm_system.springbootback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm_system.springbootback.dto.EmployeeDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.mapper.EmployeeMapper;
import com.crm_system.springbootback.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
//    @Override
//    public IPage<User> selectUserPage(QueryDTO queryDTO) {
//        Page<User> page=new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
//        return employeeMapper.selectUserPage(page,queryDTO.getKeyword());
//    }
    @Override
    public Integer addEmployee(EmployeeDTO employeeDTO) {
        Employee employee=new Employee(employeeDTO.getUsername(),employeeDTO.getPassword(),employeeDTO.getEmail(),employeeDTO.getUsertype());
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
    public  Employee selectOne(EmployeeDTO employeeDTO){
        //通过登录名查询用户
        QueryWrapper<Employee> wrapper = new QueryWrapper();
        wrapper.eq("username", employeeDTO.getUsername());
        Employee employee=employeeMapper.selectOne(wrapper);
        System.out.println(employee);
        return employee;
    }
    @Override
    public Employee findEmployById(int parseInt){
       Employee employee= employeeMapper.selectById(parseInt);
       return employee;
    }
}
