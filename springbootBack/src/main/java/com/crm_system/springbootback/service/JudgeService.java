package com.crm_system.springbootback.service;

import com.crm_system.springbootback.entity.Judge;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.mapper.JudgeMapper;
import com.crm_system.springbootback.mapper.PlanMapper;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JudgeService {
    @Autowired(required = false)
    private JudgeMapper judgeMapper;
        public List<Judge> selectAll() {
            return   judgeMapper.selectAll();
        }
        public Object deleteById(int id) {
            return judgeMapper.deleteById(id);
        }
        public Integer addJudge(Judge judge) {
            return judgeMapper.insert(judge);
        }

    public Object selectPerformanceByDate(String judged_people, String judge_time) {
            return judgeMapper.selectPerformanceByDate(judged_people,judge_time);
    }
}
