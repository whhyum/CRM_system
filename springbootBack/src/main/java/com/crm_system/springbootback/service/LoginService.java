package com.crm_system.springbootback.service;

import com.crm_system.springbootback.dto.LoginDTO;
import com.crm_system.springbootback.response.Result;

public interface LoginService {
    public Result login(LoginDTO loginDTO);
}