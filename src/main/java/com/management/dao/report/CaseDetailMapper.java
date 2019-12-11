package com.management.dao.report;

import com.management.pojo.report.CaseDetail;
import org.apache.ibatis.annotations.Param;

public interface CaseDetailMapper {
    int insert(CaseDetail record);

    int insertSelective(CaseDetail record);
    int getBaoZData(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData1(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData2(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData3(@Param("date_begin") String date_begin, @Param("date_end") String date_end);

    int getBaoZData6(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData7(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData8(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData9(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData12(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData13(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData14(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData15(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData18(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData19(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData20(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData21(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData25(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData26(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
//    int go1(XgwVo xgwVo);
}