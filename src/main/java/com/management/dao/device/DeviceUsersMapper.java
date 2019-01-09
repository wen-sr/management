package com.management.dao.device;


import com.management.pojo.device.DeviceUsers;

import java.util.List;

public interface DeviceUsersMapper {
    int deleteByPrimaryKey(Integer deviceUserId);

    int insert(DeviceUsers record);

    int insertSelective(DeviceUsers record);

    DeviceUsers selectByPrimaryKey(Integer deviceUserId);

    int updateByPrimaryKeySelective(DeviceUsers record);

    int updateByPrimaryKey(DeviceUsers record);

    List<DeviceUsers> selectAll();
}