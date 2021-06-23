//package com.crm_system.springbootback.controller;
//
//import com.crm_system.springbootback.dto.AddUserDTO;
//import com.crm_system.springbootback.entity.User;
//import com.crm_system.springbootback.response.Result;
//import com.crm_system.springbootback.response.ResultGenerator;
//import com.crm_system.springbootback.service.MailReceiver;
//import com.crm_system.springbootback.service.UserService;
//import com.crm_system.springbootback.tool.NewCore;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class Email {
//    @Autowired
//    MailReceiver mailReceiver;
//    @Autowired
//    UserService userService;
//    static String s="";
//    @PostMapping("/send")
//    private Result send() {
//        NewCore newCore=new NewCore();
//        s=newCore.getRandom();
//        mailReceiver.sendSimpleMail("1452588824@qq.com", "2466921236@qq.com", "1452588824@qq.com", "验证码",s );
//        return ResultGenerator.genOkResult("true");
//    }
//    @PostMapping("/checkCore")
//    private Result checkCore(@RequestBody AddUserDTO addUserDTO){
//        if (addUserDTO.getCore().equals(s))
//            return ResultGenerator.genOkResult(false);
//        else if(userService.selectOne(addUserDTO)==null){
//            return ResultGenerator.genFailedResult("用户名已存在，请重新输入！");
//        }
//        else {
//            User user=new User();
//            user.setLoginName(addUserDTO.getLoginName());
//            user.setEmail(addUserDTO.getEmail());
//            user.setAddress(addUserDTO.getAddress());
//            user.setPassword(addUserDTO.getPassword());
//            userService.addUser(user);
//            return ResultGenerator.genOkResult(true);
//        }
//
//
//    }
//
//}
