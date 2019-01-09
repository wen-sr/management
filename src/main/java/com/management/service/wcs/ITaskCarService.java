package com.management.service.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskCar;

public interface ITaskCarService {
    ServerResponse updateStatus(TaskCar taskCar);
}
