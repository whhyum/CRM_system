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
    private String customer_name;
    private Integer process_status;
    private String input_user;
    private String status;
    private Integer praise;
    private String type;
    private String process_type;

    public Trace(String trace_details, String trace_type, String trace_result, String customer_name, Integer process_status, String input_user, String status, String type,String process_type) {
        trace_time=new Date()  ;
        this.trace_details = trace_details;
        this.trace_type = trace_type;
        this.trace_result = trace_result;
        this.customer_name = customer_name;
        this.process_status = process_status;
        this.input_user = input_user;
        this.status = status;
        this.type = type;
        this.process_type=process_type;
    }

    public Trace(Integer id, Date trace_time, String trace_details, Date end_time, String trace_type, String trace_result, String customer_name, Integer process_status, String input_user, String status, Integer praise, String type,String process_type) {
        this.id = id;
        this.trace_time = trace_time;
        this.trace_details = trace_details;
        this.end_time = end_time;
        this.trace_type = trace_type;
        this.trace_result = trace_result;
        this.customer_name = customer_name;
        this.process_status = process_status;
        this.input_user = input_user;
        this.status = status;
        this.praise = praise;
        this.type = type;
        this.process_type=process_type;
    }
}
