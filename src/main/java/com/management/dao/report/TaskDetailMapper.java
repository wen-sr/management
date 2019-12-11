package com.management.dao.report;

import com.management.pojo.report.TaskDetail;
import org.apache.ibatis.annotations.Param;

public interface TaskDetailMapper {
    int deleteByPrimaryKey(String taskdetailkey);

    int insert(TaskDetail record);

    int insertSelective(TaskDetail record);

    TaskDetail selectByPrimaryKey(String taskdetailkey);

    int updateByPrimaryKeySelective(TaskDetail record);

    int updateByPrimaryKey(TaskDetail record);
    int getQingPeiData(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData1(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData2(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData3(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData25(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData4(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData26(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData5(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData6(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData7(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData8(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData9(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData10(@Param("date_begin") String date_begin, @Param("date_end") String date_end);



}