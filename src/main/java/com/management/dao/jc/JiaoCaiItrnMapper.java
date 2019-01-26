package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiItrn;

public interface JiaoCaiItrnMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiItrn record);

    int insertSelective(JiaoCaiItrn record);

    JiaoCaiItrn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiItrn record);

    int updateByPrimaryKey(JiaoCaiItrn record);
}