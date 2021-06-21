package com.crm_system.springbootback.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    private Integer id;
    private String username;
    private String password;

}
