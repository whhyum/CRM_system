package com.crm_system.springbootback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDTO {
    @JsonProperty(value="username")
    private String username;
    @JsonProperty(value="password")
    private String password;
    @JsonProperty(value="role_id")
    private Integer role_id;

}