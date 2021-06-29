package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Contract;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.ContractService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ContractController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/contract/add")
//    @UserToken
    public Result addContract(@RequestBody Contract contract){
        return ResultUtil.success("添加合同成功",contractService.addContract(contract));
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
//    @UserToken
    @PostMapping("/contract/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
            return ResultUtil.success("true",contractService.selectContractPage(queryDTO));
    }
//    @UserToken
    @PostMapping("/selectByTrace_id")
    public Result selectByTrace_id(Integer trace_id){
        Object type=contractService.selectByTrace_id(trace_id);
        if (type==null)
            return ResultUtil.msg(201,"没有合同","null");
        else
            return ResultUtil.msg(202,"已查找",type);

    }
//    @UserToken
    @PostMapping("/selectByUsername")
    public Result selectByUsername(String username){
        List<Contract> type=contractService.selectByUsername(username);
        if (type==null||type.size()==0)
            return ResultUtil.msg(201,"没有合同","null");
        else
            return ResultUtil.msg(202,"已查找",type);
    }
    @PostMapping("/contract/num")
//    @UserToken
    public Result selectNum(String keyWord){
        return ResultUtil.success("true",contractService.selectNum(keyWord));
    }
}
