package com.crm_system.springbootback.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String loginName;
    private String password;
    //省略getter、setter
}