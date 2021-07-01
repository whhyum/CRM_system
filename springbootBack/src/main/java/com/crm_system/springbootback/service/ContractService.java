package com.crm_system.springbootback.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crm_system.springbootback.dto.QueryDTO;
import com.crm_system.springbootback.entity.Contract;
import com.crm_system.springbootback.entity.Employee;
import com.crm_system.springbootback.entity.Transfer;
import com.crm_system.springbootback.entity.User;
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

    public Object selectByTrace_id(Integer trace_id) {
        return contractMapper.selectByTrace_id(trace_id);
    }

    public List<Contract> selectByUsername(String username) {

        return contractMapper.selectByUsername(username);
    }

    public double selectMoneyByDate(String date) {
        return contractMapper.selectMoneyByDate(date);
    }

    public Integer selectNum(String keyWord) {
        return contractMapper.selectNum(keyWord);
    }

    public IPage<Contract> selectContractPage(QueryDTO queryDTO) {
        Page<Contract> page=new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return contractMapper.selectContractPage(page,queryDTO.getUsername(),queryDTO.getRole_id());
    }

    public double selectMoneyByDateAndJob(String job, String date) {
        Object dd=contractMapper.selectMoneyByDateAndJob(job,date);
        if(dd!=null)
            return Double.parseDouble(dd.toString());
        else
            return 0;
    }
}