package com.crm_system.springbootback.controller;
import com.alibaba.fastjson.JSONObject;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.service.LoginService;
import com.crm_system.springbootback.service.TokenService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping(value = "/api/login")
    @CrossOrigin
    public JSONObject login(@RequestBody LoginDTO loginDTO){
      return loginService.login(loginDTO);
    }
    //测试方法
    @GetMapping("/getMessage")
    @ResponseBody
    @UserToken
    public String getMessage(){
        System.out.println("访问成功");
        return "你已通过验证";
    }
}