package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TraceDTO;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.entity.Trace;
import com.crm_system.springbootback.mapper.TraceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceService {
    @Autowired(required = false)
    private TraceMapper traceMapper;

    public Integer addTrace(TraceDTO traceDTO) {
        Trace trace=new Trace(traceDTO.getTrace_details(),traceDTO.getTrace_type(),traceDTO.getTrace_result(),traceDTO.getCustomer_name(),traceDTO.getProcess_status(),traceDTO.getInput_user(),
                traceDTO.getStatus(),traceDTO.getType(),traceDTO.getProcess_type());
        return traceMapper.insert(trace);
    }

    public IPage<Trace> selectTracePage(QueryDTO queryDTO) {
        Page<Trace> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return traceMapper.selectTracePage(page, queryDTO.getKeyword(),queryDTO.getFromTime(),queryDTO.getToTime(),queryDTO.getTrace_type());
    }

    public List<Trace> select(String date, String input_user) {
        return traceMapper.select(date,input_user);
    }
}