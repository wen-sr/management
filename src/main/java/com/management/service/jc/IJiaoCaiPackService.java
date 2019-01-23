package com.management.service.jc;

import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiPack;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 12:44
 * Modified By：
 */
public interface IJiaoCaiPackService {
    ServerResponse findAll(JiaoCaiPack jiaoCaiPack);

    ServerResponse add(JiaoCaiPack jiaoCaiPack);

    ServerResponse delete(JiaoCaiPack jiaoCaiPack);

    ServerResponse update(JiaoCaiPack jiaoCaiPack);
}
