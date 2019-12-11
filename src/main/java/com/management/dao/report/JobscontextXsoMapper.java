package com.management.dao.report;

import com.management.pojo.report.JobscontextXso;
import com.management.pojo.report.JobscontextXsoKey;
import com.management.vo.xgw.XgwVo;

import java.util.List;

public interface JobscontextXsoMapper {
    int deleteByPrimaryKey(JobscontextXsoKey key);

    int insert(JobscontextXso record);

    int insertSelective(JobscontextXso record);

    JobscontextXso selectByPrimaryKey(JobscontextXsoKey key);

    int updateByPrimaryKeySelective(JobscontextXso record);

    int updateByPrimaryKey(JobscontextXso record);
    int go(XgwVo xgwVo);
    List<XgwVo> cx(XgwVo xgwVo);
    int go1(XgwVo xgwVo);
    int go2(XgwVo xgwVo);
}