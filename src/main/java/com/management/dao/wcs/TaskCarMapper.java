package com.management.dao.wcs;

import com.management.pojo.wcs.TaskCar;

import java.util.List;

public interface TaskCarMapper {
    int insert(TaskCar record);

    int insertSelective(TaskCar record);

    String selectByBoxno(TaskCar record);

    int updateStatus(TaskCar taskCar);

    List<TaskCar> selectByContainerCode(String containerCode);
}