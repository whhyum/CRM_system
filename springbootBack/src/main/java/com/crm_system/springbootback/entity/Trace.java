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
    private String traceTime;
    private String traceDetails;
    private String endTime;
    private String traceType;
    private String traceResult;
    private String customerName;
    private Integer processStatus;
    private String inputUser;
    private String status;
    private Integer praise;
    private String type;
    private String processType;

    public Trace(String trace_details, String trace_type, String trace_result, String customer_name, Integer process_status, String input_user, String status, String type,String process_type) {
        traceTime= String.valueOf(new Date());
        this.traceDetails = trace_details;
        this.traceType = trace_type;
        this.traceResult = trace_result;
        this.customerName = customer_name;
        this.processStatus = process_status;
        this.inputUser = input_user;
        this.status = status;
        this.type = type;
        this.processType=process_type;
    }

    public Trace(Integer id, Date trace_time, String trace_details, Date end_time, String trace_type, String trace_result, String customer_name, Integer process_status, String input_user, String status, Integer praise, String type,String process_type) {
        this.id = id;
        this.traceTime = String.valueOf(trace_time);
        this.traceDetails = trace_details;
        this.endTime = String.valueOf(end_time);
        this.traceType = trace_type;
        this.traceResult = trace_result;
        this.customerName = customer_name;
        this.processStatus = process_status;
        this.inputUser = input_user;
        this.status = status;
        this.praise = praise;
        this.type = type;
        this.processType=process_type;
    }

    public Trace() {
    }
}
