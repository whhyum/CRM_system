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
//    private String sex;
//    private String email;
//    private String address;
    //省略getter、setter等

//    public User(String loginName, String userName, String password, String sex, String email, String address) {
//        this.id = id;
//        this.loginName = loginName;
//        this.userName = userName;
//        this.password = password;
//        this.sex = sex;
//        this.email = email;
//        this.address = address;
//    }
//
//    public User() {
//
//    }
}