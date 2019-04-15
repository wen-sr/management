package com.management.dao.busi;

import com.management.pojo.busi.SendOpenidList;

import java.util.List;

public interface SendOpenidListMapper {
    int insert(SendOpenidList record);

    int insertSelective(SendOpenidList record);

    List<SendOpenidList> selectByType(String type);
}