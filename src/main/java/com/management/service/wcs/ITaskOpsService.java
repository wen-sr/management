package com.management.service.wcs;

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
}
