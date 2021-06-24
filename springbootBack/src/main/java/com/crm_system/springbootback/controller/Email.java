package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.dto.EmployeeDTO;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.MailReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crm_system.springbootback.tool.NewCore;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class Email {
    @Autowired
    MailReceiver mailReceiver;
    @Autowired
    EmployeeService employeeService;
    static String s="";

    @PostMapping("/send")
    private Result send() {
        NewCore newCore=new NewCore();
        s=newCore.getRandom();
        mailReceiver.sendSimpleMail("1452588824@qq.com", "2466921236@qq.com", "1452588824@qq.com", "验证码",s );
        return ResultUtil.success("验证码已发送",null);
    }
    @PostMapping("/checkCore")
    private Result checkCore(@RequestBody EmployeeDTO employeeDTO){
        if (!employeeDTO.getCode().equals(s))
            return ResultUtil.fail("验证码错误！请重新输入",null) ;
        else if(employeeService.selectOne(employeeDTO)!=null){
            return ResultUtil.fail("用户名已存在！请输入新的用户名",null);
        }
        else {

           if(employeeService.addEmployee(employeeDTO)==1) {
               mailReceiver.sendSimpleMail("1452588824@qq.com", "2466921236@qq.com", "1452588824@qq.com", "入职","欢迎入职" );
               return ResultUtil.success("用户注册成功！", null);
           }
           else
               return ResultUtil.fail("用户注册失败，请检查信息格式",null);
        }
    }

}
