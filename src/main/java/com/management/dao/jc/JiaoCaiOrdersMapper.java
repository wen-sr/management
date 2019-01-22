package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiOrders;

public interface JiaoCaiOrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiOrders record);

    int insertSelective(JiaoCaiOrders record);

    JiaoCaiOrders selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiOrders record);

    int updateByPrimaryKey(JiaoCaiOrders record);
}