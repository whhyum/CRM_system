package com.crm_system.springbootback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.mapper.LoginMapper;
import com.crm_system.springbootback.mapper.UserMapper;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername())){
            return ResultUtil.fail("用户名不能为空","");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return ResultUtil.fail("密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username", loginDTO.getUsername());
        User user= loginMapper.selectOne(wrapper);
        //比较密码
        if (user!=null&&user.getPassword().equals(loginDTO.getPassword())){
//            System.out.println(user.getUsername());
            return ResultUtil.success("登录成功", user);
        }else if(!user.getPassword().equals(loginDTO.getPassword())){
            return ResultUtil.fail("用户名或密码出错","");
        }else
        return ResultUtil.fail("登录失败","");
    }
}