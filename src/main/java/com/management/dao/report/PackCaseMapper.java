package com.management.dao.report;

import com.management.pojo.report.PackCase;
import org.apache.ibatis.annotations.Param;

public interface PackCaseMapper {
    int deleteByPrimaryKey(String packid);

    int insert(PackCase record);

    int insertSelective(PackCase record);

    PackCase selectByPrimaryKey(String packid);

    int updateByPrimaryKeySelective(PackCase record);

    int updateByPrimaryKey(PackCase record);
    int getBaoZData4(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData5(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData10(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData11(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData16(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData17(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData22(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData23(@Param("date_begin") String date_begin, @Param("date_end") String date_end);

}