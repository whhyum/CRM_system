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
    private String serverName;
    private String title;
    private String communicateWay;
    private String detail;
    private String start;
    private String end;
    private String traceId;
    private String color;


    public Plan(Integer id, String server_name, String title, String communicate_way, String detail, String start, String end) {
        this.id = id;
        this.serverName = server_name;
        this.title = title;
        this.communicateWay = communicate_way;
        this.detail = detail;
        this.start = start;
        this.end = end;
    }

    public Plan(String server_name, String title, String communicate_way, String detail, String end) {
        this.serverName = server_name;
        this.title = title;
        this.communicateWay = communicate_way;
        this.detail = detail;
        this.end = end;
        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；
        this.start=dFormat.format(new Date());
    }

    public Plan() {
    }

    public Plan(Integer id, String serverName, String title, String communicateWay, String detail, String start, String end, String traceId, String color) {
        this.id = id;
        this.serverName = serverName;
        this.title = title;
        this.communicateWay = communicateWay;
        this.detail = detail;
        this.start = start;
        this.end = end;
        this.traceId = traceId;
        this.color = color;
    }
}
