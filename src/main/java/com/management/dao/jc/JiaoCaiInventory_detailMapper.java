package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiInventory_detail;

public interface JiaoCaiInventory_detailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiInventory_detail record);

    int insertSelective(JiaoCaiInventory_detail record);

    JiaoCaiInventory_detail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiInventory_detail record);

    int updateByPrimaryKey(JiaoCaiInventory_detail record);

    JiaoCaiInventory_detail selectByIssuenumberAndSubcodeAndPack(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    int addInventoryDetail(JiaoCaiInventory_detail jiaoCaiInventory_detail);
}