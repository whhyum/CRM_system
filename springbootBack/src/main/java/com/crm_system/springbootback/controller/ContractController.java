package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TransferDTO;
import com.crm_system.springbootback.entity.Contract;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ContractService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/contract")
    public Result addContract(@RequestBody TransferDTO transferDTO){
//        Contract transfer=new Contract(transferDTO);
//        contractService.updateSeller(transfer.getCustomer(),transfer.getNew_seller());
//        contractService.addTransfer(transfer);
        return ResultUtil.success("移交成功",null);
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/contract/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",contractService.selectContractPage(queryDTO));
    }
}
