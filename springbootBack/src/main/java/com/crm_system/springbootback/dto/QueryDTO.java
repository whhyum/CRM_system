package com.crm_system.springbootback.dto;

import lombok.Data;

@Data
public class QueryDTO {
    private Integer pageNo;    //页码
    private Integer pageSize;  //页面大小
    private String keyword;    //关键字
    //省略getter、setter
}