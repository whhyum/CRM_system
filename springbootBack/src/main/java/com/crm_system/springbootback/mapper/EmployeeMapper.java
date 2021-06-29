package com.crm_system.springbootback.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeMapper extends BaseMapper<Employee> {
     Object select(String date, String username) ;
    void updatePerformance(String judged_people, double performance);
    List<Employee> selectEmployeePage(String keyword);
    Integer selectNum(String keyWord);
    List<Double> getPerformance();
    List<String> getUsername();
}
