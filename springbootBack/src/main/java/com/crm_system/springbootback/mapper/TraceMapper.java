package com.crm_system.springbootback.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Trace;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TraceMapper extends BaseMapper<Trace> {

//    IPage<Trace> selectTracePage(Page<Trace> page, String keyword, String fromTime,String toTime,String username,Integer role_id);
    List<Trace> selectTracePage(String keyword, String fromTime,String toTime,String username,Integer role_id);
    List<String>selectByname(String username);
    List<Trace> select(String date, String input_user);
    Integer selectNum(String keyWord);
    List<Trace> selectTop4ByDate();
}