package com.crm_system.springbootback.dto;

import lombok.Data;

@Data

public class AddUserDTO {
    private String core;
    private Integer id;
    private String loginName;
    private String userName;
    private String password;
    private String sex;
    private String email;
    private String address;
}
