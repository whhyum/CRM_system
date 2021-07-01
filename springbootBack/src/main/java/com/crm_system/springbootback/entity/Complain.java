package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@TableName(value="complain")
public class Complain {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private  String username="匿名";
    private String context;
    private String inputUser;
    private Integer core;
    private Date complainTime;

    public Complain(String context, String input_user, int core) {
        this.context = context;
        this.inputUser = input_user;
        this.core = core;
<<<<<<< HEAD
//        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //HH表示24小时制；
=======
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //HH表示24小时制；
>>>>>>> 5f77898c925877700b73b514a75a01df4ca86cb1
        this.complainTime=new Date();
    }

    public Complain(Integer id, String username, String context, String input_user, Integer core) {
        this.id = id;
        this.username = username;
        this.context = context;
        this.inputUser = input_user;
        this.core = core;
        this.complainTime=new Date();
    }

    public Complain(Integer id, String username, String context, String input_user, Integer core, Date complain_time) {
        this.id = id;
        this.username = username;
        this.context = context;
        this.inputUser = input_user;
        this.core = core;
        this.complainTime = complain_time;
    }
}
