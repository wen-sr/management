package com.management.service.jc;

import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiInventory;
import com.management.pojo.jc.JiaoCaiInventory_detail;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 18:53
 * Modified By：
 */
public interface IJiaoCaiInventoryService {
    int add(JiaoCaiInventory jiaoCaiInventory, JiaoCaiInventory_detail jiaoCaiInventory_detail);

    ServerResponse<PageInfo> selectInventoryDetail(Integer pageSize, Integer pageNum, JiaoCaiInventory_detail jiaoCaiInventory_detail);
}
