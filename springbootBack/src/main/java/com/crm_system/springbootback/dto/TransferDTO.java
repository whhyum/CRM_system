package com.crm_system.springbootback.dto;

import lombok.Data;

@Data
public class TransferDTO {
    private String customer;
    private String trans_user;
    private String old_seller;
    private String new_seller;
    private String trans_reason;
}
