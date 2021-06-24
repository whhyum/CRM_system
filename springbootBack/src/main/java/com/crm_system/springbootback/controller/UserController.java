<<<<<<< HEAD
//package com.crm_system.springbootback.controller;
//
//import com.crm_system.springbootback.dto.QueryDTO;
//import com.crm_system.springbootback.entity.User;
//import com.crm_system.springbootback.response.Result;
//import com.crm_system.springbootback.response.ResultGenerator;
//import com.crm_system.springbootback.service.UserService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 分页查询
//     * @param queryDTO
//     * @return
//     */
//    @PostMapping("/user/list")
//    public Result userList(@RequestBody QueryDTO queryDTO){
//        return ResultGenerator.genOkResult(userService.selectUserPage(queryDTO));
//    }
//
//    /**
//     * 添加
//     * @param user
//     * @return
//     */
//    @PostMapping("/user/add")
//    public Result addUser(@RequestBody User user){
//
//        return ResultGenerator.genFailedResult("hhh",userService.addUser(user));
//    }
//
//    /**
//     * 更新
//     * @param user
//     * @return
//     */
//    @PostMapping("/user/update")
//    public Result updateUser(@RequestBody User user){
//        return ResultGenerator.genOkResult(userService.updateUser(user));
//    }
//
//    /**
//     * 删除
//     * @param id
//     * @return
//     */
//    @PostMapping("/user/delete")
//    public Result deleteUser(Integer id){
//        return ResultGenerator.genOkResult(userService.deleteUser(id));
//    }
//
//    /**
//     * 批量删除
//     * @param ids
//     * @return
//     */
//    @PostMapping("/user/delete/batch")
//    public Result batchDeleteUser(@RequestBody List<Integer> ids){
//        userService.batchDelete(ids);
//        return ResultGenerator.genOkResult();
//    }
//}
//=======
////package com.crm_system.springbootback.controller;
////
////import com.crm_system.springbootback.dto.QueryDTO;
////import com.crm_system.springbootback.entity.User;
////import com.crm_system.springbootback.response.Result;
////import com.crm_system.springbootback.response.ResultGenerator;
////import com.crm_system.springbootback.service.UserService;
////import io.swagger.v3.oas.annotations.parameters.RequestBody;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import java.util.List;
////
////@RestController
////public class UserController {
////    @Autowired
////    private UserService userService;
////
////    /**
////     * 分页查询
////     * @param queryDTO
////     * @return
////     */
////    @PostMapping("/user/list")
////    public Result userList(@RequestBody QueryDTO queryDTO){
////        return ResultGenerator.genOkResult(userService.selectUserPage(queryDTO));
////    }
////
////    /**
////     * 添加
////     * @param user
////     * @return
////     */
////    @PostMapping("/user/add")
////    public Result addUser(@RequestBody User user){
////        return ResultGenerator.genOkResult(userService.addUser(user));
////    }
////
////    /**
////     * 更新
////     * @param user
////     * @return
////     */
////    @PostMapping("/user/update")
////    public Result updateUser(@RequestBody User user){
////        return ResultGenerator.genOkResult(userService.updateUser(user));
////    }
////
////    /**
////     * 删除
////     * @param id
////     * @return
////     */
////    @PostMapping("/user/delete")
////    public Result deleteUser(Integer id){
////        return ResultGenerator.genOkResult(userService.deleteUser(id));
////    }
////
////    /**
////     * 批量删除
////     * @param ids
////     * @return
////     */
////    @PostMapping("/user/delete/batch")
////    public Result batchDeleteUser(@RequestBody List<Integer> ids){
////        userService.batchDelete(ids);
////        return ResultGenerator.genOkResult();
////    }
////}
//>>>>>>> 972a231691e0815e23ce7045f6ae1a9e4cf93bac
=======
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
     * @param user
     * @return
     */
//    @PostMapping("/user/add")
//    public Result addUser(@RequestBody UserDTO userDTO){
//
//        return ResultUtil.success("用户添加成功！",userService.addUser(userDTO));
//    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PostMapping("/user/update")
    public Result updateUser(@RequestBody User user){
        return ResultUtil.success("true",userService.updateUser(user));
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/user/delete")
    public Result deleteUser(Integer id){
        return ResultUtil.success("true",userService.deleteUser(id));
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/user/delete/batch")
    public Result batchDeleteUser(@RequestBody List<Integer> ids){
        userService.batchDelete(ids);
        return ResultUtil.success("true",null);
    }
}

>>>>>>> 86c99d11c46bbe92de42bddc2d8b04f1c1c967f8
