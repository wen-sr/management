package com.management.dao.report;

import com.management.pojo.report.TaskCase;
import com.management.vo.taskCase.QxbVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskCaseMapper {
    int deleteByPrimaryKey(String caseoutid);

    int insert(TaskCase record);

    int insertSelective(TaskCase record);

    TaskCase selectByPrimaryKey(String caseoutid);

    int updateByPrimaryKeySelective(TaskCase record);

    int updateByPrimaryKey(TaskCase record);
    List<QxbVo> getTaskCaseData(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int updateTaskCaseData(TaskCase taskCase);

    int updateCaseid(TaskCase taskCase);


}