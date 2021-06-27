package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TraceDTO;
import com.crm_system.springbootback.dto.UserDTO;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.TraceService;
import com.crm_system.springbootback.service.UserService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class TraceController {
    @Autowired
    private TraceService traceService;
    @Autowired
    private UserService userService;
    @PostMapping("/trace/add")
    @UserToken
    public Result addTrace(@RequestBody TraceDTO traceDTO){
        if(userService.selectByName(traceDTO.getCustomer_name())==null)
            return ResultUtil.fail("不存在该客户，请确认该用户名是否正确输入",null);
        else{
            if(traceService.addTrace(traceDTO)==1)
                return ResultUtil.success("用户添加成功！",null);
            else
                return ResultUtil.fail("用户信息不规范或者重名，请检查信息后重新录入",null);
        }
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/trace/list")
//    @UserToken
    public Result traceList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",traceService.selectTracePage(queryDTO));
    }
}