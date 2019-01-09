package com.management.dao.device;


import com.management.pojo.device.DeviceStatus;

import java.util.List;

public interface DeviceStatusMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(DeviceStatus record);

    int insertSelective(DeviceStatus record);

    DeviceStatus selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(DeviceStatus record);

    int updateByPrimaryKey(DeviceStatus record);

    List<DeviceStatus> findAll(DeviceStatus deviceStatus);
}