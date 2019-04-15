package com.management.service.busi;

import com.management.common.ServerResponse;
import com.management.pojo.busi.BusiMessageWx;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/15 13:12
 * Modified By：
 */
public interface IBusiMessageWxService {
    ServerResponse queryInfo(Integer pageSize, Integer pageNum, BusiMessageWx busiMessageWx);

    ServerResponse addInfo(BusiMessageWx busiMessageWx);

    ServerResponse queryInfo2(BusiMessageWx busiMessageWx);
}
