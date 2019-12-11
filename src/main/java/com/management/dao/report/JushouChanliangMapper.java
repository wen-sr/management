package com.management.dao.report;

import com.management.pojo.report.JushouChanliang;
import org.apache.ibatis.annotations.Param;

public interface JushouChanliangMapper {
    int insert(JushouChanliang record);

    int insertSelective(JushouChanliang record);
    int getBaoZData24(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
    int getBaoZData28(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
}