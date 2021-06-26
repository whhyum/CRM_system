package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TransferDTO;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.TraceService;
import com.crm_system.springbootback.service.TransferService;
import com.crm_system.springbootback.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceController {
    @Autowired
    private TraceService traceService;
//    @PostMapping("/trace")
//    public Result addTrace(@RequestBody TransferDTO transferDTO){
//        userService.updateSeller(transfer.getCustomer(),transfer.getNew_seller());
//        transferService.addTransfer(transfer);
//        return ResultUtil.success("移交成功",null);
//    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/trace/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",traceService.selectTracePage(queryDTO));
    }
}