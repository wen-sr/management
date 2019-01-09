package com.management.service.device;

import com.management.common.ServerResponse;
import com.management.pojo.device.DeviceTrans;

public interface IDeviceTransService {
    ServerResponse addTake(DeviceTrans deviceTrans);

    ServerResponse deviceReturn(DeviceTrans deviceTrans);


    ServerResponse query(DeviceTrans deviceTrans);
}
