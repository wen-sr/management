package com.management.dao.report;

import com.management.pojo.report.Replenishment;
import com.management.pojo.report.ReplenishmentKey;
import org.apache.ibatis.annotations.Param;

public interface ReplenishmentMapper {
    int deleteByPrimaryKey(ReplenishmentKey key);

    int insert(Replenishment record);

    int insertSelective(Replenishment record);

    Replenishment selectByPrimaryKey(ReplenishmentKey key);

    int updateByPrimaryKeySelective(Replenishment record);

    int updateByPrimaryKey(Replenishment record);
    int getQingPeiData19(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getQingPeiData20(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
}