package com.management.dao.report;

import com.management.pojo.report.CaseId;
import com.management.pojo.report.CaseIdKey;
import com.management.vo.caseid.WeiVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CaseIdMapper {
    int deleteByPrimaryKey(CaseIdKey key);

    int insert(CaseId record);

    int insertSelective(CaseId record);

    CaseId selectByPrimaryKey(CaseIdKey key);

    int updateByPrimaryKeySelective(CaseId record);

    int updateByPrimaryKey(CaseId record);

    List<WeiVo> getCaseIdData(@Param("date_begin") String date_begin, @Param("date_end") String date_end, @Param("type") String type);

    int getBaoZData27(@Param("date_begin") String date_begin, @Param("date_end") String date_end);
//    int go2(XgwVo xgwVo);
}
