package com.crm_system.springbootback.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.dto.UserDTO;

import java.util.List;

public interface UserService {
    public IPage<User> selectUserPage(QueryDTO queryDTO);
    public Integer addUser(User user);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
    public void batchDelete(List<Integer> ids);
    public User selectOne(UserDTO addUserDTO);
}
