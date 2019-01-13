package com.management.dao.wcs;

import com.management.pojo.wcs.TaskWms;

import java.util.List;

public interface TaskWmsMapper {
    int deleteByPrimaryKey(String sn);

    int insert(TaskWms record);

    int insertSelective(TaskWms record);

    TaskWms selectByPrimaryKey(String sn);

    int updateByPrimaryKeySelective(TaskWms record);

    int updateByPrimaryKey(TaskWms record);

    List<TaskWms> selectByConnbr(String connbr);
}