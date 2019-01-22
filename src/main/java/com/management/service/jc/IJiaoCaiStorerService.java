package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiStorer;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:51
 * Modified By：
 */
public interface IJiaoCaiStorerService {
    ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiStorer jiaoCaiStorer);
}
