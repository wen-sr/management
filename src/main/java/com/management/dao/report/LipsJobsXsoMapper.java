package com.management.dao.report;

import com.management.pojo.report.LipsJobsXso;
import com.management.vo.lipsJobsXso.WjVo;

import java.util.List;

public interface LipsJobsXsoMapper {
    int deleteByPrimaryKey(String docNumber);

    int insert(LipsJobsXso record);

    int insertSelective(LipsJobsXso record);

    LipsJobsXso selectByPrimaryKey(String docNumber);

    int updateByPrimaryKeySelective(LipsJobsXso record);

    int updateByPrimaryKey(LipsJobsXso record);
    List<WjVo> wj(WjVo wjVo);
}