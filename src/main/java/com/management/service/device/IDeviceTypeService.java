package com.management.service.device;

import com.management.common.ServerResponse;
import com.management.pojo.device.DeviceType;
import com.management.vo.device.DeviceTypeVo;

import java.util.List;

public interface IDeviceTypeService {
    List<DeviceTypeVo> findAll();

    ServerResponse addDeviceType(DeviceType deviceType);

    ServerResponse editDeviceType(DeviceType deviceType);

    ServerResponse deleteDeviceType(DeviceType deviceType);
}
