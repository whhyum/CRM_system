package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description: 用户实体类
 **/
@Data
@TableName(value="user")
public class User {
    @TableId(type = IdType.AUTO)
    @Id
    private Integer id;
//    private String loginName;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}