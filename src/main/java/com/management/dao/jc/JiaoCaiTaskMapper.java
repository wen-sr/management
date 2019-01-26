package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiTask;

public interface JiaoCaiTaskMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiTask record);

    int insertSelective(JiaoCaiTask record);

    JiaoCaiTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiTask record);

    int updateByPrimaryKey(JiaoCaiTask record);
}