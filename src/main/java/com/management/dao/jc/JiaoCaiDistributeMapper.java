package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiDistribute;

import java.util.List;

public interface JiaoCaiDistributeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiDistribute record);

    int insertSelective(JiaoCaiDistribute record);

    JiaoCaiDistribute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiDistribute record);

    int updateByPrimaryKey(JiaoCaiDistribute record);

    List<JiaoCaiDistribute> findAll(JiaoCaiDistribute jiaoCaiDistribute);
}