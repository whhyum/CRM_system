package com.crm_system.springbootback.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.mapper.TransferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
    @Autowired(required = false)
    private TransferMapper transferMapper;
    public Integer addTransfer(Transfer transfer){
       return transferMapper.insert(transfer);
    }
    public IPage<Transfer> selectTransferPage(QueryDTO queryDTO) {
        Page<Transfer> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return transferMapper.selectTransferPage(page,queryDTO.getKeyword());
    }

    public Integer selectNum(String keyWord) {
        return transferMapper.selectNum(keyWord);
    }
}
