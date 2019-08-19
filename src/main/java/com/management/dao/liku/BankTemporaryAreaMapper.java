package com.management.dao.liku;

import com.management.pojo.liku.BankTemporaryArea;

public interface BankTemporaryAreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BankTemporaryArea record);

    int insertSelective(BankTemporaryArea record);

    BankTemporaryArea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankTemporaryArea record);

    int updateByPrimaryKey(BankTemporaryArea record);
}