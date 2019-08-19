package com.management.dao.liku;

import com.management.pojo.liku.BankHoists;

public interface BankHoistsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BankHoists record);

    int insertSelective(BankHoists record);

    BankHoists selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankHoists record);

    int updateByPrimaryKey(BankHoists record);


}