package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.entity.Judge;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ComplainService;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.JudgeService;
import com.crm_system.springbootback.service.TraceService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class JudgeController {
    @Autowired
    JudgeService judgeService;
    @Autowired
    TraceService traceService;
    @Autowired
    ComplainService complainService;
    @Autowired
    EmployeeService employeeService;
    @PostMapping(value = "/judge/add")
    @ResponseBody
    @UserToken
    public Result addJudge(@RequestBody Judge judge){
        judgeService.addJudge(judge);
        double performance=judge.getWorking_ability()*0.4+judge.getWorking_attitude()*0.2+
                judge.getEnvironmental_behavior()*0.1+judge.getDiscipline()*0.1+
                judge.getBonus_point()*0.2+judge.getDeduct_point()*0.1;
        employeeService.updatePerformance(judge.getJudged_people(),performance);
        return ResultUtil.success("添加成功",performance);
    }
    @PostMapping(value = "/judge/selectAll")
    @ResponseBody
    @UserToken
    public Result addJudge(){
        return ResultUtil.success("查询成功",judgeService.selectAll());
    }
    @PostMapping(value = "/show")
    @ResponseBody
    @UserToken
    public Result show(String date,String input_user){
        Map<String,Object> map=new HashMap<>();
        map.put("form1",complainService.select(date,input_user));
        map.put("from2",traceService.select(date,input_user));
        return ResultUtil.success("查询成功",map);
    }

}
