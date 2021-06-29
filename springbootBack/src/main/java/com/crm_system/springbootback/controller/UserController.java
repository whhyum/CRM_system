package com.crm_system.springbootback.controller;

import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import com.crm_system.springbootback.service.UserService;
import com.crm_system.springbootback.tool.UserToken;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
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
//    @UserToken
    public Result userList(@RequestBody QueryDTO queryDTO){
        return ResultUtil.success("true",userService.queryusersByArray(queryDTO.getPageNo(),queryDTO.getPageSize(),queryDTO.getKeyword()));
    }
    @PostMapping("/user/add")
//    @UserToken
    public Result addUser(@RequestBody User user){
        RegisterDTO registerDTO=new RegisterDTO();
        registerDTO.setUsername(user.getUsername());
        if(user.getUsername().isEmpty()){
            return ResultUtil.fail("用户名不可以为空！",null);
        }
       else if (userService.selectOne(registerDTO) != null) {
            return ResultUtil.fail("用户名已存在！请输入新的用户名", null);
        }
        else {
        if(userService.addUser(user)==1)
             return ResultUtil.success("用户添加成功！",null);
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
//    @UserToken
    public Result updateUser(@RequestBody User user){
        return ResultUtil.success("true",userService.updateUser(user));
    }
    @PostMapping("/user/updateTime")
//    @UserToken
    public Result updateUser(Integer id){
        return ResultUtil.success("true",userService.setTime(id));
    }
    @PostMapping("/user/updateStatus")
//    @UserToken
    public Result updateUser(Integer id,String status){
        return ResultUtil.success("true",userService.updateStatus(id,status));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/user/delete")
//    @UserToken
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
//    @UserToken
    public Result batchDeleteUser(@RequestParam(value = "ids",required = false) List<Integer> ids){
        userService.batchDelete(ids);
        return ResultUtil.success("true",null);
    }
    @PostMapping("/user/selectStar")
//    @UserToken
    public Result selectStar(){
        return ResultUtil.success("true",userService.selectStar());
    }
    @PostMapping("/user/num")
//    @UserToken
    public Result selectNum(String keyWord){
        return ResultUtil.success("true",userService.selectNum(keyWord));
    }
    @PostMapping("/user/getTypeData")
//    @UserToken
    public Result getTypeData(){
        Map<String,Double> map=new HashMap<>();
        String[] value={"流失","开发失败","潜在客户","正式客户","资源池客户"};
        double[] num=new double[5];
        int all=userService.selectNum(null);
        System.out.println(all);
        for(int i=0;i<value.length;i++){
             num[i]=userService.getTypeData(value[i]);
             map.put(value[i],num[i]/all*100);
        }
        return ResultUtil.success("true",map);
    }
}
