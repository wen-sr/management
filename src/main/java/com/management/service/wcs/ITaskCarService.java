package com.management.service.wcs;

import com.management.common.ServerResponse;
import com.management.pojo.wcs.TaskCar;

import java.util.List;

public interface ITaskCarService {
    ServerResponse updateStatus(TaskCar taskCar);

    List<TaskCar> selectByContainerCode(String containerCode);
}
