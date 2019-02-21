package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiTaskDetail;

import java.util.List;

public interface JiaoCaiTaskDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiaoCaiTaskDetail record);

    int insertSelective(JiaoCaiTaskDetail record);

    JiaoCaiTaskDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JiaoCaiTaskDetail record);

    int updateByPrimaryKey(JiaoCaiTaskDetail record);

    List<JiaoCaiTaskDetail> selectAll(JiaoCaiTaskDetail jiaoCaiTaskDetail);
}