package com.management.dao.wcs;

import com.management.pojo.wcs.TaskCar;

public interface TaskCarMapper {
    int insert(TaskCar record);

    int insertSelective(TaskCar record);

    String selectByBoxno(TaskCar record);

    int updateStatus(TaskCar taskCar);
}