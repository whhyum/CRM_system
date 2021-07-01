package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName(value="employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private Integer age;
    private String department;
    private String hireDate;
    private String state;
    private Integer admin;
    private Integer roleId;
    private Double performance;

    public Employee(String username, String password, String email, Integer usertype) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.roleId=usertype;
        this.hireDate= String.valueOf(new Date());
    }

    public Employee() {
    }

    public Employee(Integer id, String username, String password, String email, String gender, Integer age, String department, Date hireDate, String state, Integer admin, Integer roleId, Double performance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.hireDate = String.valueOf(hireDate);
        this.state = state;
        this.admin = admin;
        this.roleId = roleId;
        this.performance = performance;
    }
}
