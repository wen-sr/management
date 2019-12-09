package com.management.service.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskOps;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/13 20:12
 * Modified By：
 */
public interface ITaskOpsService {
    List<TaskOps> selectByConnbr(String connbr);

    /******************ganhong***********************/
    ServerResponse getTaskOpsData(TaskOps taskOps);
    /******************ganhong***********************/
}
