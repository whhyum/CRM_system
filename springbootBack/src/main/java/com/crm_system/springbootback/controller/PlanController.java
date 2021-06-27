package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.PlanService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping("/plan/selectAll")
    @UserToken
    public Result selectAll() {
        return ResultUtil.success("true", planService.selectAll());
    }
    @PostMapping("/plan/updatePlan")
    @UserToken
    public Result updatePlan(@RequestBody Plan plan) {
        return ResultUtil.success("true", planService.updatePlan(plan));
    }
    @PostMapping("/plan/deleteById")
    @UserToken
    public Result deleteById(int id) {
        return ResultUtil.success("true", planService.deleteById(id));
    }
    @PostMapping("/plan/addPlan")
    @UserToken
    public Result addPlan(@RequestBody Plan plan) {

        return ResultUtil.success("true", planService.addPlan(plan));
    }
}