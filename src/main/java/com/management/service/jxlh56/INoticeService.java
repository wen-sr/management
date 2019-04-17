package com.management.service.jxlh56;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.jxlh56.News;
import com.management.pojo.jxlh56.Notice;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/17 13:35
 * Modified By：
 */
public interface INoticeService {
    EasyuiTableResponse queryInfo(Integer pageSize, Integer pageNum, Notice news);

    ServerResponse queryInfo2(int i, int i1, Notice news);

    ServerResponse queryById(Notice news);

    ServerResponse sendToWechat(List<Integer> ids);
}
