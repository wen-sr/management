package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiInventory;

public interface JiaoCaiInventoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiInventory record);

    int insertSelective(JiaoCaiInventory record);

    JiaoCaiInventory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiInventory record);

    int updateByPrimaryKey(JiaoCaiInventory record);
}