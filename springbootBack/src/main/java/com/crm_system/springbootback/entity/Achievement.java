package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;
@Data
@TableName(value="achievement")
public class Achievement {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String server_name;
    private Date date;
    private Double performance;
}
