package com.management.dao.prd1;


import com.management.pojo.prd1.TaskView;
import com.management.vo.prd1.TaskViewDto;

import java.util.List;

public interface TaskViewMapper {
    int insert(TaskView record);

    int insertSelective(TaskView record);

    List<TaskViewDto> getData(TaskViewDto taskView);

    String selectBoxno(String boxno);
}