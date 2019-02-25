package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiContainerLoc;

public interface JiaoCaiContainerLocMapper {
    int deleteByPrimaryKey(String containerId);

    int insert(JiaoCaiContainerLoc record);

    int insertSelective(JiaoCaiContainerLoc record);

    JiaoCaiContainerLoc selectByPrimaryKey(String containerId);

    int updateByPrimaryKeySelective(JiaoCaiContainerLoc record);

    int updateByPrimaryKey(JiaoCaiContainerLoc record);
}