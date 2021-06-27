package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Contract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContractMapper extends BaseMapper<Contract> {
    IPage<Contract> selectContractPage(Page<Contract> page, String keyword);

    Object selectByTrace_id(Integer trace_id);

    List<Contract> selectByUsername(String username);
}
