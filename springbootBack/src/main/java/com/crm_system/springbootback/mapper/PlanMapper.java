package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.service.PlanService;

import java.util.List;

public interface PlanMapper extends BaseMapper<Plan> {

    List<Plan> selectAll();
}
