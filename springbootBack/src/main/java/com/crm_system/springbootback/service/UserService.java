package com.crm_system.springbootback.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.RegisterDTO;
import com.crm_system.springbootback.entity.User;
import com.crm_system.springbootback.dto.UserDTO;
import java.util.List;

public interface UserService {
    public List<User> selectStar() ;
    public Integer addUser(UserDTO UserDTO);
    public Integer addUser(RegisterDTO registerDTO);
    public Integer updateUser(User user);
    public Integer deleteUser(Integer id);
    public void batchDelete(List<Integer> ids);
    public User selectOne(UserDTO addUserDTO);
    public User selectOne(RegisterDTO registerDTO);
    public Integer setTime(Integer id);
    Object updateStatus(Integer id, String status);
    Object updateSeller(String customer, String new_seller);
    Integer selectByName(String name);
    User findUserById(int parseInt);
    int addUser(User user);
    Integer selectNum(String keyWord);
    int getTypeData(String s);
    Object selectByJob(String job);
    List<User>  queryusersByArray(Integer pageNo, Integer pageSize, String keyword);
}
