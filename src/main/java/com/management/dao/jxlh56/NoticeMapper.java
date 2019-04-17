package com.management.dao.jxlh56;

import com.management.pojo.jxlh56.News;
import com.management.pojo.jxlh56.Notice;

import java.util.List;

public interface NoticeMapper {
    int insert(Notice record);

    int insertSelective(Notice record);

    List<News> findAll(Notice notice);

    List<News> findAll2();

    News queryById(Integer id);

    void updateStatus(List<Integer> notice);
}