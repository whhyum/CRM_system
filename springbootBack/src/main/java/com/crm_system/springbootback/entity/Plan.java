package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value="plan")
public class Plan {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer server_id;
    private String type;
    private Integer diary_id;
}
