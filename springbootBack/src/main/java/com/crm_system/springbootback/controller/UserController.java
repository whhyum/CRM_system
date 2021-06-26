package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.UserDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/user/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",userService.selectUserPage(queryDTO));
    }

    /**
     * 添加
     * @param userDTO
     * @return
     */
    @PostMapping("/user/add")
    public Result addUser(@RequestBody UserDTO userDTO){
        if(userDTO.getUsername()==null)
            return ResultUtil.fail("用户名不可以为空",null);
        else{
        if(userService.addUser(userDTO)==1)
             return ResultUtil.success("用户添加成功！",userService.addUser(userDTO));
        else
            return ResultUtil.fail("用户信息不规范或者重名，请检查信息后重新录入",null);
    }
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public Result updateUser(@RequestBody User user){
        return ResultUtil.success("true",userService.updateUser(user));
    }
    @PostMapping("/user/updateTime")
    public Result updateUser(Integer id){
        return ResultUtil.success("true",userService.setTime(id));
    }
    @PostMapping("/user/updateStatus")
    public Result updateUser(Integer id,String status){
        return ResultUtil.success("true",userService.updateStatus(id,status));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/user/delete")
    public Result deleteUser(Integer id){
        if(userService.deleteUser(id)==1)
             return ResultUtil.success("用户已删除",userService.deleteUser(id));
        else
            return ResultUtil.fail("删除用户失败",userService.deleteUser(id));
    }

    /**
     * 批量删除

     * @return
     */
    @PostMapping("/user/delete/batch")
    public Result batchDeleteUser(@RequestParam(value = "ids",required = false) List<Integer> ids){
        userService.batchDelete(ids);
        return ResultUtil.success("true",null);
    }
}

