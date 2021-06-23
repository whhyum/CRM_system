package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.service.LoginService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping(value = "/api/login")
    @CrossOrigin
    public Result login(@RequestBody LoginDTO loginDTO){
      return loginService.login(loginDTO);
    }

    @PostMapping("/test")
    public User test(){
        return new User("111","1111");
    }
}