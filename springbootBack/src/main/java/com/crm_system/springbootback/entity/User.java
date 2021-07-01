package com.crm_system.springbootback.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Column;
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
    private Integer age;
    private String tel;
    private String seller="";//负责人
    private String inputUser;
    private String area;
    private String job;
    private String source;
    private Date inputTime;
    private String status="资源池客户";
    private Date positiveTime;
    private boolean star;
    private Integer roleId;

    public User(Integer id, String username, String password, String gender, String email, Integer age, String tel, String seller, String input_user, String area, String job, String source, Date input_time, String status, Date positive_time,boolean star,Integer role_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.tel = tel;
        this.seller= seller;
        this.inputUser = input_user;
        this.area = area;
        this.job = job;
        this.source = source;
        this.inputTime = input_time;
        this.status = status;
        this.positiveTime = positive_time;
        this.star=star;
        this.roleId=role_id;
    }
    public User(String employee, String username, String gender, String email, Integer age, String tel, String area, String job, String source) {
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.tel = tel;
        this.area = area;
        this.job = job;
        this.source = source;
        this.inputTime= new Date();
        this.positiveTime=new Date();
        this.seller=employee;
        this.inputUser=employee;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.inputTime= new Date();
        this.positiveTime=new Date();
    }

    public User() {
    }

}