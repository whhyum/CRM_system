package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TransferDTO;
import com.crm_system.springbootback.entity.Contract;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ContractService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/contract/add")
    @UserToken
    public Result addContract(@RequestBody Contract contract){
        return ResultUtil.success("添加合同成功",contractService.addContract(contract));
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @UserToken
    @PostMapping("/contract/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",contractService.selectContractPage(queryDTO));
    }
    @UserToken
    @PostMapping("/selectByTrace_id")
    public Result selectByTrace_id(Integer trace_id){
        return ResultUtil.success("true",contractService.selectByTrace_id(trace_id));
    }
    @UserToken
    @PostMapping("/selectByUsername")
    public Result selectByUsername(String username){
        return ResultUtil.success("true",contractService.selectByUsername(username));
    }
}
