package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowDistribution;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 15:25
 * Modified By：
 */
public interface IAllowDistributionService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowDistribution allowDistribution);
}
