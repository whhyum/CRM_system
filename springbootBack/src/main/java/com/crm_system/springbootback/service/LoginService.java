package com.crm_system.springbootback.service;

import com.alibaba.fastjson.JSONObject;
import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.response.Result;

public interface LoginService {
    public JSONObject login(LoginDTO loginDTO);
}