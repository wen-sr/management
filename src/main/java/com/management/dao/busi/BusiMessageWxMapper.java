package com.management.dao.busi;

import com.management.pojo.busi.BusiMessageWx;

import java.util.List;

public interface BusiMessageWxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BusiMessageWx record);

    int insertSelective(BusiMessageWx record);

    BusiMessageWx selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BusiMessageWx record);

    int updateByPrimaryKey(BusiMessageWx record);

    List<BusiMessageWx> selectAll(BusiMessageWx busiMessageWx);

}