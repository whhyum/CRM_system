package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crm_system.springbootback.entity.Complain;

import java.util.List;

public interface ComplainMapper extends BaseMapper<Complain> {
    List<Complain> select(String date, String input_user);
}
