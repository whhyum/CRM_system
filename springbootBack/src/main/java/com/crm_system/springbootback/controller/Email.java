package com.crm_system.springbootback.controller;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.EmployeeService;
import com.crm_system.springbootback.service.MailReceiver;
import com.crm_system.springbootback.service.UserService;
import com.crm_system.springbootback.tool.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crm_system.springbootback.tool.NewCore;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin
@RestController
public class Email {
    @Autowired
    MailReceiver mailReceiver;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;
    static String s="";

    @PostMapping("/send")
//    @UserToken
    private Result send(String email) {
        NewCore newCore=new NewCore();
        s=newCore.getRandom();
        if(email.isEmpty()){
            return ResultUtil.fail("邮箱不可以为空!","");
        }
        else {
            mailReceiver.sendSimpleMail("1452588824@qq.com", email, "1452588824@qq.com", "验证码", s);
            return ResultUtil.success("验证码已发送", null);
        }
    }
//    @UserToken
    @PostMapping("/checkCore")
    private Result checkCore(@RequestBody RegisterDTO registerDTO) {
        if (!registerDTO.getCode().equals(s))
            return ResultUtil.fail("验证码错误！请重新输入", null);
        else {
            if (registerDTO.getRole_id() == 1) {
                if (userService.selectOne(registerDTO) != null) {
                    return ResultUtil.fail("用户名已存在！请输入新的用户名", null);
                } else {
                    if (userService.addUser(registerDTO) == 1) {
                        return ResultUtil.success("用户注册成功！", null);
                    } else
                        return ResultUtil.fail("用户注册失败，请检查信息格式", null);
                }
            }
            else if (registerDTO.getRole_id() == 2 || registerDTO.getRole_id() == 3) {
                if (employeeService.selectOne(registerDTO) != null) {
                    return ResultUtil.fail("用户名已存在！请输入新的用户名", null);
                } else {
                    if (employeeService.addEmployee(registerDTO) == 1) {
                        mailReceiver.sendSimpleMail("1452588824@qq.com", "2466921236@qq.com", "1452588824@qq.com", "入职", "欢迎入职");
                        return ResultUtil.success("用户注册成功！", null);
                    }
                   else
                    return ResultUtil.fail("用户注册失败，请检查信息格式", null);
                }
            }
        else
           return ResultUtil.fail("用户注册失败，请检查信息格式", null);
        }
    }
}
