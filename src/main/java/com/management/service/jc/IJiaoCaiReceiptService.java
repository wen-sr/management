package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiReceipt;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 17:47
 * Modified By：
 */
public interface IJiaoCaiReceiptService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiReceipt jiaoCaiReceipt);

    ServerResponse delete(JiaoCaiReceipt jiaoCaiReceipt);

    ServerResponse add(JiaoCaiReceipt jiaoCaiReceipt);

    ServerResponse update(JiaoCaiReceipt jiaoCaiReceipt);
}
