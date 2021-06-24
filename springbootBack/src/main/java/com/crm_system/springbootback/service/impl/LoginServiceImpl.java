package com.crm_system.springbootback.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.mapper.EmployeeMapper;
import com.crm_system.springbootback.mapper.UserMapper;
import com.crm_system.springbootback.service.LoginService;
import com.crm_system.springbootback.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    TokenService tokenService;
    @Override
    public JSONObject login(LoginDTO loginDTO) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(loginDTO.getUsername())) {
            jsonObject.put("msg", "用户名不能为空");
            jsonObject.put("status", 404);
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())) {
            jsonObject.put("msg", "密码不能为空");
            jsonObject.put("status", 404);
        }
        //通过登录名查询用户
        if(loginDTO.getStatus()!=1) {
            QueryWrapper<Employee> wrapper = new QueryWrapper();
            wrapper.eq("username", loginDTO.getUsername());
            Employee employee = employeeMapper.selectOne(wrapper);
            //比较密码
            if (employee == null) {
                jsonObject.put("msg", "用户名不存在");
                jsonObject.put("status", 404);
            } else if (employee != null && employee.getPassword().equals(loginDTO.getPassword())) {
//            System.out.println(user.getUsername());
                String token = tokenService.getToken(employee);
                jsonObject.put("token", token);
                jsonObject.put("status", 200);
                jsonObject.put("employee", employee);
                jsonObject.put("msg", "登录成功");
            } else if (!employee.getPassword().equals(loginDTO.getPassword())) {
                jsonObject.put("msg", "用户名或密码出错");
                jsonObject.put("status", 404);
            }
        }
        else if(loginDTO.getStatus()==1){
            QueryWrapper<User> wrapper = new QueryWrapper();
            wrapper.eq("username", loginDTO.getUsername());
            User user = userMapper.selectOne(wrapper);
            //比较密码
            if (user == null) {
                jsonObject.put("msg", "用户名不存在");
                jsonObject.put("status", 404);
            } else if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
//            System.out.println(user.getUsername());
                String token = tokenService.getToken(user);
                jsonObject.put("token", token);
                jsonObject.put("status", 200);
                jsonObject.put("employee", user);
                jsonObject.put("msg", "登录成功");
            } else if (!user.getPassword().equals(loginDTO.getPassword())) {
                jsonObject.put("msg", "用户名或密码出错");
                jsonObject.put("status", 404);
            }
        }
        return jsonObject;
    }
}