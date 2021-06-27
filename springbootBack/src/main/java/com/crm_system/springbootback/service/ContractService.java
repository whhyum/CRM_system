package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Contract;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.mapper.ContractMapper;
import com.crm_system.springbootback.mapper.TransferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired(required = false)
    private ContractMapper contractMapper;
    public Integer addContract(Contract contract){
        return contractMapper.insert(contract);
    }
    public IPage<Contract> selectContractPage(QueryDTO queryDTO) {
        Page<Contract> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return contractMapper.selectContractPage(page,queryDTO.getKeyword());
    }
    public Object selectByTrace_id(Integer trace_id) {
        return contractMapper.selectByTrace_id(trace_id);
    }

    public List<Contract> selectByUsername(String username) {
        return contractMapper.selectByUsername(username);
    }
}