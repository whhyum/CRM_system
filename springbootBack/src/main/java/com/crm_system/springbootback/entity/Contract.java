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
    private Integer server_id;
    private Date creat_time;
    private Date finish_time;
    private String server_type;
    private Integer money;
    private String pay_type;
    private String money_status;
    private String contract_status;
}
