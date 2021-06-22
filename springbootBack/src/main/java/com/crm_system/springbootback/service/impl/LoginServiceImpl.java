package com.crm_system.springbootback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.mapper.UserMapper;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultGenerator;
import com.crm_system.springbootback.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        if (loginDTO.getPassword().equals("")){
            return ResultGenerator.genFailedResult(400,"账号不能为空","");
        }
        if (loginDTO.getPassword().equals("")){
            return ResultGenerator.genFailedResult(400,"密码不能为空","");
        }
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("login_name", loginDTO.getLoginName());
        User uer=userMapper.selectOne(wrapper);
        //比较密码
        if (uer!=null&&uer.getPassword().equals(loginDTO.getPassword())){
            return ResultGenerator.genOkResult(uer);
        }
        return ResultGenerator.genFailedResult(400,"登录失败","");
    }
}