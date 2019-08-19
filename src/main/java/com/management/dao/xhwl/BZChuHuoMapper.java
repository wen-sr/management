package com.management.dao.xhwl;

import com.management.pojo.xhwl.BZChuHuo;

import java.util.List;

public interface BZChuHuoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BZChuHuo record);

    int insertSelective(BZChuHuo record);

    BZChuHuo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BZChuHuo record);

    int updateByPrimaryKey(BZChuHuo record);

    List<BZChuHuo> findAll(BZChuHuo bzChuHuo);
}