package com.crm_system.springbootback.dto;

import lombok.Data;

@Data
public class UserDTO {
    public  String employee;
    private String username;
    private Integer age;
    private String gender;
    private String tel;
    private String email;
    private String job;
    private String source;
    private String area;
}
