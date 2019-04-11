package com.management.dao.jxlh56;

import com.management.pojo.jxlh56.News;

import java.util.List;

public interface NewsMapper {
    int insert(News record);

    int insertSelective(News record);

    List<News> findAll();

    List<News> findByIds(List<Integer> ids);
}