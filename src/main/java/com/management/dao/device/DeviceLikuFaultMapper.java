package com.management.dao.device;

import com.management.pojo.device.DeviceLikuFault;

public interface DeviceLikuFaultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceLikuFault record);

    int insertSelective(DeviceLikuFault record);

    DeviceLikuFault selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceLikuFault record);

    int updateByPrimaryKey(DeviceLikuFault record);
}