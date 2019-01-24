package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiIssuenumber;

import java.util.List;

public interface JiaoCaiIssuenumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JiaoCaiIssuenumber record);

    int insertSelective(JiaoCaiIssuenumber record);

    JiaoCaiIssuenumber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JiaoCaiIssuenumber record);

    int updateByPrimaryKey(JiaoCaiIssuenumber record);

    List<JiaoCaiIssuenumber> findAll(JiaoCaiIssuenumber jiaoCaiIssuenumber);
}