package com.management.dao.jxlh56;

import com.management.pojo.jxlh56.News;

public interface NewsMapper {
    int insert(News record);

    int insertSelective(News record);
}