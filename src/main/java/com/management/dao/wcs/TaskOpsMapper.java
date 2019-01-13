package com.management.dao.wcs;

import com.management.pojo.wcs.TaskOps;

import java.util.List;

public interface TaskOpsMapper {
    int deleteByPrimaryKey(String sn);

    int insert(TaskOps record);

    int insertSelective(TaskOps record);

    TaskOps selectByPrimaryKey(String sn);

    int updateByPrimaryKeySelective(TaskOps record);

    int updateByPrimaryKey(TaskOps record);

    List<TaskOps> selectByConnbr(String connbr);
}