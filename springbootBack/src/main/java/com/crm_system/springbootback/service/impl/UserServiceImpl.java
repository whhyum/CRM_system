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

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public List<User> selectStar() {
        return userMapper.selectStar();
    }
    @Override
    public Integer addUser(UserDTO userDTO) {
        User user=new User(userDTO.getEmployee(),userDTO.getUsername(),userDTO.getGender(),userDTO.getEmail(),userDTO.getAge(),userDTO.getTel(),
        userDTO.getArea(),userDTO.getJob(),userDTO.getSource());
        return userMapper.insert(user);
    }
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

    @Override
    public Integer setTime(Integer id) {
        return userMapper.setTime(id);
    }

    @Override
    public Object updateStatus(Integer id, String status) {
        return userMapper.updateStatus(id,status);
    }

    @Override
    public Object updateSeller(String customer, String new_seller) {

        return userMapper.updateSeller(customer,new_seller);
    }

    @Override
    public Integer selectByName(String name) {

        return userMapper.selectByName(name);
    }
    @Override
    public User findUserById(int parseInt){
        User user= userMapper.selectById(parseInt);
        return user;
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer selectNum(String keyWord) {
        return userMapper.selectNum(keyWord);
    }

    @Override
    public int getTypeData(String s) {
        return userMapper.getTypeData(s);
    }

    @Override
    public Object selectByJob(String job) {
        return userMapper.selectByJob(job);
    }

    @Override
    public List<User> queryusersByArray(Integer pageNo, Integer pageSize, String keyword) {
        List<User> user = userMapper.queryusersByArray(keyword);
//        从第几条数据开始
        int firstIndex = (pageNo - 1) * pageSize;
//        到第几条数据结束
        int lastIndex = pageNo * pageSize;
        if(lastIndex>user.size()){
            lastIndex=user.size();
        }
        return user.subList(firstIndex, lastIndex);
//        return user;
    }

}