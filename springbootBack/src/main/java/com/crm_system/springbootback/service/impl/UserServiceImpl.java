package com.crm_system.springbootback.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.dto.UserDTO;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.mapper.UserMapper;
import com.crm_system.springbootback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    /**
    * 分页查询
    **/
    @Override
    public IPage<User> selectUserPage(QueryDTO queryDTO) {
        Page<User> page=new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return userMapper.selectUserPage(page,queryDTO.getKeyword());
    }

//    @Override
//    public Integer addUser(UserDTO userDTO) {
//        User user=new User(userDTO.getUsername(),userDTO.getGender(),userDTO.getEmail(),userDTO.getAge(),userDTO.getTel(),
//        userDTO.getArea(),userDTO.getJob(),userDTO.getSource());
//        return userMapper.insert(user);
//    }
    @Override
    public Integer addUser(RegisterDTO registerDTO) {
        User user=new User(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getEmail());
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }
    @Override
    public  User selectOne(UserDTO userDTO){
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username", userDTO.getUsername());
        User uer=userMapper.selectOne(wrapper);
        return uer;
    }
    @Override
    public  User selectOne(RegisterDTO registerDTO){
        //通过登录名查询用户
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username", registerDTO.getUsername());
        User uer=userMapper.selectOne(wrapper);
        return uer;
    }
}