package com.management.service.xhwl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.xhwl.BZChuHuo;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/8/12 10:36
 * Modified By：
 */
public interface IBZChuHuoService {
    EasyuiTableResponse loadData(Integer pageSize, Integer pageNum, BZChuHuo bzChuHuo);

    ServerResponse addInfo(BZChuHuo bzChuHuo);

    void SendWx();
}
