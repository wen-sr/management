package com.management.service.xhwl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.vo.xhwl.JiaoCaiPlanDataVo;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/8 10:55
 * Modified By：
 */
public interface IJiaoCaiPlanDataService {
    ServerResponse saveRecords(List<List<Object>> listob);

    EasyuiTableResponse findAll(JiaoCaiPlanDataVo jiaoCaiPlanDataVo, Integer pageSize, Integer pageNum);

    List<JiaoCaiPlanDataVo> issueNumberTips();

    List<JiaoCaiPlanDataVo> plantingnameTips();

    List<JiaoCaiPlanDataVo> subcodeTips();

    List<JiaoCaiPlanDataVo> typeTips();

}
