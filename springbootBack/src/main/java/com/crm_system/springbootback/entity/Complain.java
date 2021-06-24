package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName(value="complain")
public class Complain {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private  String username;
    private String context;
    private Integer complain_id;
    private Integer core;

}
