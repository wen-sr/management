package com.management.service.device;

import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.pojo.device.DeviceRepair;
import com.management.pojo.device.DeviceStatus;

/**
 * Description:
 * User: wen-sr
 * Date: 2017-09-20  14:08
 */
public interface DeviceStatusService {
    ServerResponse takeReturn(String deviceId, Integer deviceTypeId, Integer status, Integer userId);

    ServerResponse findAll(DeviceStatus deviceStatus, int pageSize, int currentPage);

    ServerResponse<PageInfo> findRepair(DeviceRepair deviceRepair, int pageSize, int pageNum);

    ServerResponse updateRepair(DeviceRepair deviceRepair);
}
