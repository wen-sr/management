package com.management.service.jc;

import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.pojo.jc.JiaoCaiIssuenumber;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 10:04
 * Modified By：
 */
public interface IJiaoCaiIssuenumberService {
    ServerResponse<PageInfo> getInfo(Integer pageSize, Integer pageNum, JiaoCaiIssuenumber jiaoCaiIssuenumber);

    ServerResponse add(JiaoCaiIssuenumber jiaoCaiIssuenumber);

    ServerResponse delete(JiaoCaiIssuenumber jiaoCaiIssuenumber);
}
