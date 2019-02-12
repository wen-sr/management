package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiCompute;

import java.util.List;
import java.util.Map;

public interface JiaoCaiComputeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiCompute record);

    int insertSelective(JiaoCaiCompute record);

    JiaoCaiCompute selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiCompute record);

    int updateByPrimaryKey(JiaoCaiCompute record);

    void getComputeNo(Map<String, Integer> map);

    List<JiaoCaiCompute> findAll(JiaoCaiCompute jiaoCaiCompute);
}