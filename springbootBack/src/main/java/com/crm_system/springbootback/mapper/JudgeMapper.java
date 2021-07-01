package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crm_system.springbootback.entity.Judge;
import com.crm_system.springbootback.entity.Plan;

import java.util.List;

public interface JudgeMapper extends BaseMapper<Judge> {
    List<Judge> selectAll();

    Object selectPerformanceByDate(String judged_people, String judge_time);
}
