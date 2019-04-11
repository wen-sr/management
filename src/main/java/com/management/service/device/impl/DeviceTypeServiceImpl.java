package com.management.service.device.impl;

import com.management.common.ServerResponse;
import com.management.dao.device.DeviceTypeMapper;
import com.management.dao.login.LoginMapper;
import com.management.pojo.device.DeviceType;
import com.management.pojo.login.Login;
import com.management.service.device.IDeviceTypeService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.device.DeviceTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(value = "transactionManager_xh",readOnly = false)
public class DeviceTypeServiceImpl implements IDeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Autowired
    LoginMapper loginMapper;

    @Override
    public List<DeviceTypeVo> findAll() {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<DeviceType> deviceTypeList = deviceTypeMapper.findAll();
        return this.parseToDeviceTypeVo(deviceTypeList);
    }

    @Override
    public ServerResponse addDeviceType(DeviceType deviceType) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        String deviceTypeName = deviceTypeMapper.selectByDeviceTypeName(deviceType.getDeviceTypeName());
        if(deviceTypeName != null){
            return ServerResponse.createByErrorMessage("您要添加的设备类型名称已存在");
        }
        int i = deviceTypeMapper.insertSelective(deviceType);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("设备类型添加成功");
        }else{
            return ServerResponse.createByErrorMessage("添加设备类型数据失败，请联系管理员");
        }
    }

    @Override
    public ServerResponse editDeviceType(DeviceType deviceType) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);

        int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        if(i > 0) {
            return ServerResponse.createBySuccessMsg("设备类型名称修改成功");
        }
        return ServerResponse.createByErrorMessage("设备类型名称修改失败");
    }

    @Override
    public ServerResponse deleteDeviceType(DeviceType deviceType) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        int i = deviceTypeMapper.deleteByPrimaryKey(deviceType.getDeviceTypeId());
        if(i > 0) {
            return ServerResponse.createBySuccessMsg("设备类型名称删除成功");
        }
        return ServerResponse.createByErrorMessage("设备类型名称删除失败");
    }

    private List<DeviceTypeVo> parseToDeviceTypeVo(List<DeviceType> deviceTypeList) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<DeviceTypeVo> deviceTypeVoList = new ArrayList<>();
        DeviceTypeVo deviceTypeVo = null;
        for(DeviceType d : deviceTypeList){
            deviceTypeVo = new DeviceTypeVo();
            deviceTypeVo.setDeviceTypeId(d.getDeviceTypeId());
            deviceTypeVo.setDeviceTypeName(d.getDeviceTypeName());
            deviceTypeVo.setAdddate(DateTimeUtil.dateToStr(d.getAdddate()));

            Login user = loginMapper.selectByPrimaryKey(d.getAddwho());

            if(user != null && user.getName() != null){
                deviceTypeVo.setAddwho(user.getName());
            }
            deviceTypeVo.setBk1(d.getBk1());
            deviceTypeVo.setBk2(d.getBk2());
            deviceTypeVo.setBk3(d.getBk3());
            deviceTypeVo.setBk4(d.getBk4());
            deviceTypeVo.setBk5(d.getBk5());
            deviceTypeVoList.add(deviceTypeVo);
        }

        return deviceTypeVoList;
    }




}
