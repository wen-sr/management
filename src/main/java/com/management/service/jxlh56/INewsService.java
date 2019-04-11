package com.management.service.jxlh56;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jxlh56.News;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/4 9:28
 * Modified By：
 */
public interface INewsService {
    EasyuiTableResponse queryInfo(News news);

    ServerResponse sendToWechat(List<Integer> ids);
}
