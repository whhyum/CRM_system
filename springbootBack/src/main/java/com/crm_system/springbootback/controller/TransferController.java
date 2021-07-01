package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TransferDTO;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.TransferService;
import com.crm_system.springbootback.service.UserService;
import com.crm_system.springbootback.tool.UserToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class TransferController {
    @Autowired
    private UserService userService;
    @Autowired
    private TransferService transferService;
    @PostMapping("/transfer")
//    @UserToken
    public Result addTransfer(@RequestBody TransferDTO transferDTO){
        Transfer transfer=new Transfer(transferDTO);
        userService.updateSeller(transfer.getCustomer(),transfer.getNew_seller());
        transferService.addTransfer(transfer);
        return ResultUtil.success("移交成功",null);
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/transfer/list")
//    @UserToken
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",transferService.selectTransferPage(queryDTO));
    }
    @PostMapping("/transfer/num")
//    @UserToken
    public Result selectNum(String keyWord){
        return ResultUtil.success("true",transferService.selectNum(keyWord));
    }

}
