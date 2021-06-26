package com.crm_system.springbootback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.entity.Transfer;
import org.springframework.stereotype.Component;

@Component
public interface TransferMapper extends BaseMapper<Transfer> {
    IPage<Transfer> selectTransferPage(Page<Transfer> page, String keyword);
}
