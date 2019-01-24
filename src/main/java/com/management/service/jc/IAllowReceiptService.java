package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowReceipt;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 19:55
 * Modified By：
 */
public interface IAllowReceiptService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowReceipt allowReceipt);
}
