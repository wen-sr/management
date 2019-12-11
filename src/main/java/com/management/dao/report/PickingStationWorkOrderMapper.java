package com.management.dao.report;

import com.management.pojo.report.PickingStationWorkOrder;
import org.apache.ibatis.annotations.Param;

public interface PickingStationWorkOrderMapper {
    int deleteByPrimaryKey(Integer processingid);

    int insert(PickingStationWorkOrder record);

    int insertSelective(PickingStationWorkOrder record);

    PickingStationWorkOrder selectByPrimaryKey(Integer processingid);

    int updateByPrimaryKeySelective(PickingStationWorkOrder record);

    int updateByPrimaryKey(PickingStationWorkOrder record);
    int getQingPeiData21(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData22(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
}