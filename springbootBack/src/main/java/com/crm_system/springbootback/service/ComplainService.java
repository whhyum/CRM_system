package com.crm_system.springbootback.service;
import com.crm_system.springbootback.entity.Complain;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.mapper.ComplainMapper;
import com.crm_system.springbootback.mapper.TraceMapper;
import com.crm_system.springbootback.response.Result;
import com.crm_system.springbootback.response.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService {
    @Autowired(required = false)
    private ComplainMapper complainMapper;
    @Autowired(required = false)
    private TraceMapper traceMapper;
    public Result selectInput_user(String username) {
        return ResultUtil.success("查询成功",traceMapper.selectByname(username));
    }
    public Integer addComplain(String context,String input_user,int core) {
        Complain complain=new Complain(context,input_user,core);
        return complainMapper.insert(complain);
    }

    public List<Complain> select(String date, String input_user) {

        return complainMapper.select(date,input_user);
    }
}
