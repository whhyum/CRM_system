package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Trace;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.mapper.TraceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceService {
    @Autowired(required = false)
    private TraceMapper traceMapper;

    public Integer addTrace(Trace trace) {
        return traceMapper.insert(trace);
    }

    public IPage<Trace> selectTracePage(QueryDTO queryDTO) {
        Page<Trace> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return traceMapper.selectTracePage(page, queryDTO.getKeyword());
    }
}