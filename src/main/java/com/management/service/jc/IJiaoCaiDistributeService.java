package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiDistribute;

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
}
