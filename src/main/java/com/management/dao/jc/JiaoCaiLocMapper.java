package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiLoc;

public interface JiaoCaiLocMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiLoc record);

    int insertSelective(JiaoCaiLoc record);

    JiaoCaiLoc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiLoc record);

    int updateByPrimaryKey(JiaoCaiLoc record);

    JiaoCaiLoc selectByLoc(String toLoc);
}