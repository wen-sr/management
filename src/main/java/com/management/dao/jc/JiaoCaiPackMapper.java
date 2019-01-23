package com.management.dao.jc;

import com.management.pojo.jc.JiaoCaiPack;
import com.management.pojo.jc.JiaoCaiPackKey;

import java.util.List;

public interface JiaoCaiPackMapper {
    int deleteByPrimaryKey(JiaoCaiPackKey key);

    int insert(JiaoCaiPack record);

    int insertSelective(JiaoCaiPack record);

    JiaoCaiPack selectByPrimaryKey(JiaoCaiPackKey key);

    int updateByPrimaryKeySelective(JiaoCaiPack record);

    int updateByPrimaryKey(JiaoCaiPack record);

    List<JiaoCaiPack> findAll(JiaoCaiPack jiaoCaiPack);

    int updateById(JiaoCaiPack jiaoCaiPack);
}