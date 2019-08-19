package com.management.dao.xhwl;

import com.management.pojo.xhwl.JiaoCaiPlanData;
import com.management.vo.xhwl.JiaoCaiPlanDataVo;

import java.util.List;

public interface JiaoCaiPlanDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JiaoCaiPlanData record);

    int insertSelective(JiaoCaiPlanData record);

    JiaoCaiPlanData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JiaoCaiPlanData record);

    int updateByPrimaryKey(JiaoCaiPlanData record);

    List<JiaoCaiPlanData> findAll(JiaoCaiPlanDataVo jiaoCaiPlanDataVo);

    List<JiaoCaiPlanDataVo> issueNumberTips();

    List<JiaoCaiPlanDataVo> plantingnameTips();

    List<JiaoCaiPlanDataVo> subcodeTips();

    List<JiaoCaiPlanDataVo> typeTips();

    //void deleteByIssuenumber(String issuenumber);

    List<JiaoCaiPlanDataVo> partmentTips();
}