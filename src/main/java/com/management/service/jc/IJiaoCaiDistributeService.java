package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiDistribute;
import com.management.vo.jc.JiaoCaiDistributeVo;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 14:07
 * Modified By：
 */
public interface IJiaoCaiDistributeService {
    ServerResponse add(JiaoCaiDistribute jiaoCaiDistribute);

    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiDistribute jiaoCaiDistribute);

    ServerResponse delete(JiaoCaiDistribute jiaoCaiDistribute);

    ServerResponse update(JiaoCaiDistribute jiaoCaiDistribute);

    ServerResponse loadWaitComputeData(Integer pageSize, Integer pageNum, JiaoCaiDistributeVo jiaoCaiDistributeVo);

    ServerResponse compute(List<Long> ids, Integer pack, Integer bundle);
}
