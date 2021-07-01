package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.entity.Judge;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ComplainService;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.JudgeService;
import com.crm_system.springbootback.service.TraceService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
=======
>>>>>>> 5f77898c925877700b73b514a75a01df4ca86cb1
import java.util.HashMap;
import java.util.Map;
import com.crm_system.springbootback.tool.UserToken;

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
//    @UserToken
    public Result addJudge(@RequestBody Judge judge){
        double performance=judge.getWorking_ability()*0.4+judge.getWorking_attitude()*0.2+
                judge.getEnvironmental_behavior()*0.1+judge.getDiscipline()*0.1+
                judge.getBonus_point()*0.2+judge.getDeduct_point()*0.1;
        judge.setPerformance(performance);
        judgeService.addJudge(judge);
        employeeService.updatePerformance(judge.getJudgedPeople(),performance);
        return ResultUtil.success("添加成功",performance);
    }
    @PostMapping(value = "/judge/selectAll")
    @ResponseBody
//    @UserToken
    public Result addJudge(){
        return ResultUtil.success("查询成功",judgeService.selectAll());
    }
    @PostMapping(value = "/show")
    @ResponseBody
//    @UserToken
    public Result show(String date,String input_user){
        Map<String,Object> map=new HashMap<>();
        map.put("form1",complainService.select(date,input_user));
        map.put("form2",traceService.select(date,input_user));
        return ResultUtil.success("查询成功",map);
    }
    @PostMapping(value = "/selectPerformanceByDate")
    @ResponseBody
//    @UserToken
    public Result selectPerformanceByDate(String judged_people, String judge_time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(format.parse(judge_time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return ResultUtil.success("查询成功",judgeService.selectPerformanceByDate(judged_people, format.format(cal.getTime())));
    }


}
