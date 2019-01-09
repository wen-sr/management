package com.management.service.device;

import com.management.common.ServerResponse;
import com.management.pojo.device.DeviceList;


public interface IDeviceListService {


    ServerResponse findAll(DeviceList deviceList, Integer pageSize, Integer pageNum);

    ServerResponse addDevice(DeviceList deviceList, String organizationId);

    ServerResponse deleteDevice(DeviceList deviceList);

    ServerResponse editDevice(DeviceList deviceList);
}
