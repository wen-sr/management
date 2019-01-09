package com.management.dao.device;


import com.management.pojo.device.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(Integer deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(Integer deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    List<DeviceType> findAll();

    String selectByDeviceTypeName(String deviceTypeName);
}