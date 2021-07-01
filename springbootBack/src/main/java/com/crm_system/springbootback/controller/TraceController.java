package com.crm_system.springbootback.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Trace;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.TraceService;
import com.crm_system.springbootback.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crm_system.springbootback.tool.UserToken;
@CrossOrigin
@RestController
public class TraceController {
    @Autowired
    private TraceService traceService;
    @Autowired
    private UserService userService;
    @PostMapping("/trace/add")
//    @UserToken
    public Result addTrace(@RequestBody Trace trace){
            if(traceService.addTrace(trace)==1)
                return ResultUtil.success("添加成功！",null);
            else
                return ResultUtil.fail("信息不规范或者重名，请检查信息后重新录入",null);
    }
    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/trace/list")
//    @UserToken
    public Result traceList(@RequestBody QueryDTO queryDTO){
        if(queryDTO.getRole_id()==1)
            return ResultUtil.fail("用户无此权限","");
        else {
            return ResultUtil.success("true", traceService.selectTracePage(queryDTO));
        }
    }
    @PostMapping("/trace/num")
//    @UserToken
    public Result selectNum(String keyWord){
        return ResultUtil.success("true",traceService.selectNum(keyWord));
    }
    @PostMapping("/trace/deleteById")
//    @UserToken
    public Result deleteById(Integer id){
        if(traceService.deleteTrace(id)==1)
            return ResultUtil.success("记录已删除",null);
        else
            return ResultUtil.fail("删除失败",null);
    }
    @PostMapping("/trace/update")
//    @UserToken
    public Result updateTrace(@RequestBody Trace trace){
        if(traceService.updateTrace(trace)==1)
            return ResultUtil.success("用户信息已更新",null);
        else
            return ResultUtil.fail("用户信息更新失败",null);
    }
    @PostMapping("/trace/selectTop5ByDate")
//    @UserToken
    public Result selectTop4ByDate(){
        return ResultUtil.success("true",traceService.selectTop4ByDate());
    }
}