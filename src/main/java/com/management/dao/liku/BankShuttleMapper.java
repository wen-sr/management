package com.management.dao.liku;

import com.management.pojo.liku.BankShuttle;
import com.management.vo.liku.ErrorMessageVo;

import java.util.List;

public interface BankShuttleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BankShuttle record);

    int insertSelective(BankShuttle record);

    BankShuttle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankShuttle record);

    int updateByPrimaryKey(BankShuttle record);

    List<ErrorMessageVo> getErrorMsg();
}