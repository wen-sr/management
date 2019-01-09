package com.management.dao.oa;

import com.management.pojo.oa.Performance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PerformanceMapper {
    int insert(Performance record);

    int insertSelective(Performance record);

    Performance selectInfo(Performance record);

    List<Performance> query(@Param(value = "begin") String begin, @Param(value = "end") String end, @Param(value = "name") String name);
}