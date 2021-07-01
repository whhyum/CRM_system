package com.crm_system.springbootback.controller;
import com.alibaba.fastjson.JSONObject;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.service.LoginService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crm_system.springbootback.tool.UserToken;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping(value = "/api/login")
    @ResponseBody
    public JSONObject login(@RequestBody LoginDTO loginDTO){
      return loginService.login(loginDTO);
    }
}