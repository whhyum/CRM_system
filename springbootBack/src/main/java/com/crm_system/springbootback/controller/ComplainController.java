package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ComplainService;
import com.crm_system.springbootback.tool.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ComplainController {
        @Autowired
        ComplainService complainService;
        @PostMapping(value = "/selectInput_user")
        @ResponseBody
//        @UserToken
        public Result selectInput_user(String username){

            return complainService.selectInput_user(username);
        }
    @PostMapping(value = "/complain/add")
    @ResponseBody
//    @UserToken
    public Result addComplain(String context,String input_user,int core){

        return ResultUtil.success("添加记录成功",complainService.addComplain(context,input_user,core));
    }
}
