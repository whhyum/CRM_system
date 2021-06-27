package com.crm_system.springbootback.service;

import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.mapper.PlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService{
    @Autowired(required = false)
    private  PlanMapper planMapper;
    public List<Plan> selectAll() {
      return   planMapper.selectAll();
    }
    public Integer updatePlan(Plan plan) {
        return planMapper.updateById(plan);
    }

    public Object deleteById(int id) {
        return planMapper.deleteById(id);
    }

    public Object addPlan(Plan plan) {
        return planMapper.insert(plan);
    }
}
