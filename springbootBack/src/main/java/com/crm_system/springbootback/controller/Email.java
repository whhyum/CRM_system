package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.UserDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.MailReceiver;
import com.crm_system.springbootback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import com.crm_system.springbootback.tool.NewCore;

@RestController
public class Email {
    @Autowired
    MailReceiver mailReceiver;
    @Autowired
    UserService userService;
    static String s="";
    @PostMapping("/send")
    private Result send() {
        NewCore newCore=new NewCore();
        s=newCore.getRandom();
        mailReceiver.sendSimpleMail("1452588824@qq.com", "2466921236@qq.com", "1452588824@qq.com", "验证码",s );
        return null;
    }
    @PostMapping("/test")
    private String test(){
        return s;
    }
    @PostMapping("/checkCore")
    private Result checkCore(@RequestBody UserDTO addUserDTO){
        if (!addUserDTO.getCore().equals(s))
            return null ;
        else if(userService.selectOne(addUserDTO)==null){
            return null;
        }
        else {
            return null;
        }


    }

}
