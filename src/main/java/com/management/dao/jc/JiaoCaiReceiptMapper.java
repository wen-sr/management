package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiReceipt;

public interface JiaoCaiReceiptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiaoCaiReceipt record);

    int insertSelective(JiaoCaiReceipt record);

    JiaoCaiReceipt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JiaoCaiReceipt record);

    int updateByPrimaryKey(JiaoCaiReceipt record);
}