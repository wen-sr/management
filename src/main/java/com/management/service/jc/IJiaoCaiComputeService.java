package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiCompute;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/12 13:05
 * Modified By：
 */
public interface IJiaoCaiComputeService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiCompute jiaoCaiCompute);

    ServerResponse cancelCompute(List<Long> ids);
}
