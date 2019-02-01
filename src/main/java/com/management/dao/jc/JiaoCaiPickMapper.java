package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiPick;

public interface JiaoCaiPickMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiPick record);

    int insertSelective(JiaoCaiPick record);

    JiaoCaiPick selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiPick record);

    int updateByPrimaryKey(JiaoCaiPick record);
}