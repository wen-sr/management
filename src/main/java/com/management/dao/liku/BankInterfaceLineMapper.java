package com.management.dao.liku;

import com.management.pojo.liku.BankInterfaceLine;

public interface BankInterfaceLineMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BankInterfaceLine record);

    int insertSelective(BankInterfaceLine record);

    BankInterfaceLine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BankInterfaceLine record);

    int updateByPrimaryKey(BankInterfaceLine record);
}