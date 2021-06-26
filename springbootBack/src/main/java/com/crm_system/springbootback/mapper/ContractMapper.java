package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Contract;
import org.springframework.stereotype.Component;

@Component
public interface ContractMapper extends BaseMapper<Contract> {
    IPage<Contract> selectContractPage(Page<Contract> page, String keyword);
}
