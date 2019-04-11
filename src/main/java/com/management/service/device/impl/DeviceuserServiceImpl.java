package com.management.service.device.impl;

import com.management.common.ServerResponse;
import com.management.dao.device.DeviceUsersMapper;
import com.management.pojo.device.DeviceUsers;
import com.management.service.device.IDeviceUserService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 * User: wen-sr
 * Date: 2017-09-27  8:47
 */
@Service
@Transactional(value = "transactionManager_xh",readOnly = false)
public class DeviceuserServiceImpl implements IDeviceUserService {

    @Autowired
    DeviceUsersMapper deviceUsersMapper;

    @Override
    public ServerResponse getDeviceUsers() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<DeviceUsers> deviceUsersList = deviceUsersMapper.selectAll();
        return ServerResponse.createBySuccess(deviceUsersList);
    }
}
