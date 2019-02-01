package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.AllowAllocate;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/30 12:36
 * Modified By：
 */
public interface IAllowAllocateService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowAllocate allowAllocate);
}
