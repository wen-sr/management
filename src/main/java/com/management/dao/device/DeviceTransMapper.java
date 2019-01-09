package com.management.dao.device;

import com.management.pojo.device.DeviceTrans;
import com.management.vo.device.DeviceTransVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTransMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeviceTrans record);

    int insertSelective(DeviceTrans record);

    DeviceTrans selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeviceTrans record);

    int updateByPrimaryKey(DeviceTrans record);

    DeviceTrans selectByDeviceId(@Param(value = "deviceId") String deviceId, @Param(value = "status") String status);

    List<DeviceTransVo> selectAllByDeviceId(String deviceId);
}