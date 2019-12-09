package com.management.service.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskWms;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/13 19:01
 * Modified By：
 */
public interface ITaskWmsService {
    List<TaskWms> selectByConnbr(String connbr);
    /**************ganhong*****************/
    ServerResponse getTaskWmsData(TaskWms taskWms);
    /**************ganhong*****************/
}
