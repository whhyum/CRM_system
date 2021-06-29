package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;
@Data
@TableName(value="contract")
public class Contract {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String servername;
    private String part_a;
    private String part_b;
    private String seller;
    private String creatTime;
    private String finishTime;
    private String serverType;
    private Integer money;
    private String payType;
    private String moneyStatus;
    private Integer traceId;
    private String job;

    public Contract(Integer id, String servername, String part_a, String part_b, String seller, Date creat_time, Date finish_time, String server_type, Integer money, String pay_type, String money_status, Integer trace_id,String job) {
        this.id = id;
        this.servername = servername;
        this.part_a = part_a;
        this.part_b = part_b;
        this.seller = seller;
        this.creatTime = String.valueOf(creat_time);
        this.finishTime = String.valueOf(finish_time);
        this.serverType = server_type;
        this.money = money;
        this.payType = pay_type;
        this.moneyStatus = money_status;
        this.traceId = trace_id;
        this.job=job;
    }
}
