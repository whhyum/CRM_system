package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description: 用户实体类
 **/
@Data
@TableName(value="user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password="123456";
    private String gender;
    private String email;
    private String age;
    private String tel;
    private String seller="";//负责人
    private String input_user="";
    private String area;
    private String job;
    private String source;
    private Date input_time;
    private String status="";
    private Date positive_time;

//    public User(String username, String gender, String email, String age, String tel, String area, String job, String source) {
//        this.username = username;
//        this.gender = gender;
//        this.email = email;
//        this.age = age;
//        this.tel = tel;
//        this.area = area;
//        this.job = job;
//        this.source = source;
//        this.input_time=new Date();
//        this.positive_time=new Date();
//    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.input_time=new Date();
        this.positive_time=new Date();
    }
}