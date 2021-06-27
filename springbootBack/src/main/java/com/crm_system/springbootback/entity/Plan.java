package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@TableName(value="plan")
public class Plan {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String server_name;
    private String title;
    private String communicate_way;
    private String detail;
    private String start;
    private String end;
    private String trace_id;


    public Plan(Integer id, String server_name, String title, String communicate_way, String detail, String start, String end) {
        this.id = id;
        this.server_name = server_name;
        this.title = title;
        this.communicate_way = communicate_way;
        this.detail = detail;
        this.start = start;
        this.end = end;
    }

    public Plan(String server_name, String title, String communicate_way, String detail, String end) {
        this.server_name = server_name;
        this.title = title;
        this.communicate_way = communicate_way;
        this.detail = detail;
        this.end = end;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        this.start=dFormat.format(new Date());
    }

    public Plan() {
    }
}
