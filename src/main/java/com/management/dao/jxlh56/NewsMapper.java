package com.management.dao.jxlh56;

import com.management.pojo.jxlh56.News;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    void updateStatus(List<Integer> ids);

    List<News> findAll(News news);

    List<News> findByIds(List<Integer> ids);

    List<News> findAll2();

    News queryById(Integer id);
}