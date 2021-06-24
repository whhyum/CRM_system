package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;
@Data
@TableName(value="dairy")
public class Dairy {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Date diary_date;
    private String communicate_way;
    private String communicate_content;
}
