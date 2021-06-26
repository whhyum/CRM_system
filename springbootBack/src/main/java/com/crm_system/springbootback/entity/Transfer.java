package com.crm_system.springbootback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.crm_system.springbootback.dto.TransferDTO;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "transfer")
public class Transfer {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String customer;
    private String trans_user;
    private Date trans_time;
    private String old_seller;
    private String new_seller;
    private String trans_reason;

    public Transfer(TransferDTO transferDTO) {
        this.customer = transferDTO.getCustomer();
        this.trans_user =transferDTO.getTrans_user();
        this.trans_time =new Date();
        this.old_seller = transferDTO.getOld_seller();
        this.new_seller = transferDTO.getNew_seller();
        this.trans_reason = transferDTO.getTrans_reason();
    }

    public Transfer(Integer id, String customer, String trans_user, Date trans_time, String old_seller, String new_seller, String trans_reason) {
        this.id = id;
        this.customer = customer;
        this.trans_user = trans_user;
        this.trans_time = trans_time;
        this.old_seller = old_seller;
        this.new_seller = new_seller;
        this.trans_reason = trans_reason;
    }
}
