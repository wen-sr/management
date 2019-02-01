package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiInventory_detail;

import java.util.List;

public interface JiaoCaiInventory_detailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiInventory_detail record);

    int insertSelective(JiaoCaiInventory_detail record);

    JiaoCaiInventory_detail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiInventory_detail record);

    int updateByPrimaryKey(JiaoCaiInventory_detail record);

    JiaoCaiInventory_detail selectByIssuenumberAndSubcodeAndPack(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    int addInventoryDetail(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    List<JiaoCaiInventory_detail> selectAll(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    List<JiaoCaiInventory_detail> selectByQtyfree(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    List<JiaoCaiInventory_detail> selectByQtyfree2(JiaoCaiInventory_detail jiaoCaiInventory_detail);

    List<JiaoCaiInventory_detail> selectAllTotal(JiaoCaiInventory_detail jiaoCaiInventory_detail);
}