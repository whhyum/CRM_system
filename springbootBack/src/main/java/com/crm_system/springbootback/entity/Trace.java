package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@Data
@TableName(value="trace")
public class Trace {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Date trace_time;
    private String trace_details;
    private Date end_time;
    private String trace_type;
    private String trace_result;
    private Integer customer_id;
    private Double process_status;
    private String input_user;
    private String status;
    private Integer process_day;
    private Integer praise;

}
