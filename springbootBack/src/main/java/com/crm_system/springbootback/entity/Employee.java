package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@TableName(value="employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    @Id
    private Integer id;
    private String username;
    private String password;

}
