package com.management.dao.report;

import com.management.pojo.report.PickDetail;
import org.apache.ibatis.annotations.Param;

public interface PickDetailMapper {
    int deleteByPrimaryKey(String pickdetailkey);

    int insert(PickDetail record);

    int insertSelective(PickDetail record);

    PickDetail selectByPrimaryKey(String pickdetailkey);

    int updateByPrimaryKeySelective(PickDetail record);

    int updateByPrimaryKey(PickDetail record);
    int getQingPeiData11(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData12(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData13(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData14(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData15(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData16(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData17(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData18(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData23(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData24(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData27(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData28(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
}