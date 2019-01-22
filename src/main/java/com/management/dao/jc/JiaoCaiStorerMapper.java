package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiStorer;
import com.management.pojo.jc.JiaoCaiStorerKey;

import java.util.List;

public interface JiaoCaiStorerMapper {
    int deleteByPrimaryKey(JiaoCaiStorerKey key);

    int insert(JiaoCaiStorer record);

    int insertSelective(JiaoCaiStorer record);

    JiaoCaiStorer selectByPrimaryKey(JiaoCaiStorerKey key);

    int updateByPrimaryKeySelective(JiaoCaiStorer record);

    int updateByPrimaryKey(JiaoCaiStorer record);

    List<JiaoCaiStorer> findAll(JiaoCaiStorer jiaoCaiStorer);
}