package com.management.service.prd1;

import com.management.common.ServerResponse;
import com.management.vo.prd1.LogisticsQueryVo;

public interface ILogisticsQueryService {
    ServerResponse bookShipQuery(LogisticsQueryVo logisticsQueryVo);
}
