package com.crm_system.springbootback.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Trace;
import org.springframework.stereotype.Component;

@Component
public interface TraceMapper extends BaseMapper<Trace> {
    IPage<Trace> selectTracePage(Page<Trace> page, String keyword);
}