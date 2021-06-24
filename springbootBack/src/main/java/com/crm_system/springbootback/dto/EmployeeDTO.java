package com.crm_system.springbootback.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String username;
    private String password;
    private String email;
    private String code;
    private Integer usertype;
}
