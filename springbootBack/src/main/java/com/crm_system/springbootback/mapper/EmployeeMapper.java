package com.crm_system.springbootback.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crm_system.springbootback.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeMapper extends BaseMapper<Employee> {
     Object select(String date, String username) ;
    void updatePerformance(String judged_people, double performance);
}
