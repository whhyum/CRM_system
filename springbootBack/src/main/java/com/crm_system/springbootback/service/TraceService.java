package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.dto.TraceDTO;
import com.crm_system.springbootback.entity.Plan;
import com.crm_system.springbootback.entity.Trace;
import com.crm_system.springbootback.entity.User;
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

    public List<Trace> selectTracePage(QueryDTO queryDTO) {
        List<Trace> traces = traceMapper.selectTracePage(queryDTO.getKeyword(),queryDTO.getFromTime(),queryDTO.getToTime(),queryDTO.getUsername(),queryDTO.getRole_id());
//        从第几条数据开始
        int firstIndex = (queryDTO.getPageNo() - 1) * queryDTO.getPageSize();
//        到第几条数据结束
        int lastIndex = queryDTO.getPageNo() * queryDTO.getPageSize();
        if(lastIndex>traces.size()){
            lastIndex=traces.size();
        }
        return traces.subList(firstIndex, lastIndex);

    }

    public List<Trace> select(String date, String input_user) {
        return traceMapper.select(date,input_user);
    }

    public int addTrace(Trace trace) {
        return traceMapper.insert(trace);
    }

    public Integer selectNum(String keyWord) {
        return traceMapper.selectNum(keyWord);
    }

    public int deleteTrace(Integer id) {
        return traceMapper.deleteById(id);
    }

    public int updateTrace(Trace trace) {
        return traceMapper.updateById(trace);
    }

    public List<Trace> selectTop4ByDate() {
        return traceMapper.selectTop4ByDate();
    }
}