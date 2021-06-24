package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "transfer")
public class Transfer {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String customer;
    private String trans_user;
    private Date trans_time;
    private String old_seller;
    private String new_seller;
    private String trans_reason;
}
