package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiOrders;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/23 11:47
 * Modified By：
 */
public interface IJiaoCaiOrdersService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiOrders jiaoCaiOrders);

    ServerResponse add(JiaoCaiOrders jiaoCaiOrders);

    ServerResponse update(JiaoCaiOrders jiaoCaiOrders);

    ServerResponse delete(JiaoCaiOrders jiaoCaiOrders);
}
