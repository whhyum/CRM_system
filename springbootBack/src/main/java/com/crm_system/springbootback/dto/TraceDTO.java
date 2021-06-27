package com.crm_system.springbootback.dto;

import lombok.Data;
@Data
public class TraceDTO {
    private String trace_details;
    private String trace_type;
    private String trace_result;
    private String customer_name;
    private Integer process_status;
    private String input_user;
    private String status;
    private String type;
    private String process_type;
}
