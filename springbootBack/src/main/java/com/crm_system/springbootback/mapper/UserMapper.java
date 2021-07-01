package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {
    Integer setTime(Integer id);
    Integer updateStatus(Integer id,String status);
    Integer updateSeller(String customer,String new_seller);
    Integer selectByName(String name);
    List<User> selectStar();
    Integer selectNum(String keyWord);
    int getTypeData(String s);
    Object selectByJob(String job);
    List<User> queryusersByArray(String keyword);
}