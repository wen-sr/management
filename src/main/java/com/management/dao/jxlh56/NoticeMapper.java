package com.management.dao.jxlh56;

import com.management.pojo.jxlh56.News;
import com.management.pojo.jxlh56.Notice;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<News> findAll(Notice news);

    List<News> findAll2();

    News queryById(Integer id);

    void updateStatus(List<Integer> ids);
}