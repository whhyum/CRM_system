package com.crm_system.springbootback.dto;

import lombok.Data;

import java.util.Date;

@Data
public class QueryDTO {
    private Integer pageNo;    //页码
    private Integer pageSize;  //页面大小
    private String keyword;    //关键字
    private String fromTime;
    private String toTime;
    private String trace_type;
    private Integer role_id;
    private String username;
    //省略getter、setter
}