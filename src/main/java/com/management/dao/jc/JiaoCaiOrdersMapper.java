package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiOrders;

import java.util.List;

public interface JiaoCaiOrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiOrders record);

    int insertSelective(JiaoCaiOrders record);

    JiaoCaiOrders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiOrders record);

    int updateByPrimaryKey(JiaoCaiOrders record);

    List<JiaoCaiOrders> findAll(JiaoCaiOrders jiaoCaiOrders);
}