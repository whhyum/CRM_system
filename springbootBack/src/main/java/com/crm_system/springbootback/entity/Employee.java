package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@TableName(value="employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private String department;
    private Date hire_date;
    private String state;
    private Integer admin;
    private Integer role_id;

    public Employee(String username, String password, String email, Integer usertype) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.role_id=usertype;
        this.hire_date=new Date();
    }

    public Employee() {
    }
}
