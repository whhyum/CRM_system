package com.crm_system.springbootback.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.mapper.LoginMapper;
import com.crm_system.springbootback.mapper.UserMapper;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.LoginService;
import com.crm_system.springbootback.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    TokenService tokenService;
    @Override
    public JSONObject login(LoginDTO loginDTO) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(loginDTO.getUsername())) {
            jsonObject.put("msg", "用户名不能为空");
            jsonObject.put("status", 500);
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())) {
            jsonObject.put("msg", "密码不能为空");
            jsonObject.put("status", 500);
        }
        //通过登录名查询用户
        QueryWrapper<Employee> wrapper = new QueryWrapper();
        wrapper.eq("username", loginDTO.getUsername());
        Employee employee = loginMapper.selectOne(wrapper);
        //比较密码
        if (employee == null) {
            jsonObject.put("msg", "用户名不存在");
            jsonObject.put("status", 500);
        } else if (employee != null && employee.getPassword().equals(loginDTO.getPassword())) {
//            System.out.println(user.getUsername());
            String token = tokenService.getToken(employee);
            jsonObject.put("token", token);
            jsonObject.put("status", 200);
            jsonObject.put("employee", employee);
            jsonObject.put("msg", "登录成功");
        } else if (!employee.getPassword().equals(loginDTO.getPassword())) {
            jsonObject.put("msg", "用户名或密码出错");
            jsonObject.put("status", 500);
        }
        return jsonObject;
    }
}