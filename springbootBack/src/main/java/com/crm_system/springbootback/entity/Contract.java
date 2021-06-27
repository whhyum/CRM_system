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
    private Date creat_time;
    private Date finish_time;
    private String server_type;
    private Integer money;
    private String pay_type;
    private String money_status;
//    private String contract_status;
    private Integer trace_id;

    public Contract(Integer id, String servername, String part_a, String part_b, String seller, Date creat_time, Date finish_time, String server_type, Integer money, String pay_type, String money_status, Integer trace_id) {
        this.id = id;
        this.servername = servername;
        this.part_a = part_a;
        this.part_b = part_b;
        this.seller = seller;
        this.creat_time = creat_time;
        this.finish_time = finish_time;
        this.server_type = server_type;
        this.money = money;
        this.pay_type = pay_type;
        this.money_status = money_status;
        this.trace_id = trace_id;
    }
}
