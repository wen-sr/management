package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiCompute;

public interface JiaoCaiComputeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiCompute record);

    int insertSelective(JiaoCaiCompute record);

    JiaoCaiCompute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiCompute record);

    int updateByPrimaryKey(JiaoCaiCompute record);
}