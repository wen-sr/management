package com.management.controller.device;

import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.EasyuiTableResponse;
import com.management.common.LayuiTableResponse;
import com.management.common.ServerResponse;
import com.management.pojo.device.DeviceRepair;
import com.management.pojo.device.DeviceStatus;
import com.management.pojo.login.Login;
import com.management.service.device.DeviceStatusService;
import com.management.service.device.IDeviceRepairService;
import com.management.service.device.IDeviceUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description:
 * User: wen-sr
 * Date: 2017-09-20  13:48
 */
@RestController
@RequestMapping("/device")
public class DeviceStatusController {

    @Autowired
    DeviceStatusService deviceStatusService;

    @Autowired
    IDeviceUserService deviceUserService;

    @Autowired
    IDeviceRepairService deviceRepairService;

    @RequestMapping("/takeReturn")
    public ServerResponse takeReturn(@RequestParam(value = "deviceTypeId", defaultValue = "1") Integer deviceTypeId,
                                     @RequestParam(value = "deviceId") String deviceId,
                                     @RequestParam(value = "status") Integer status,
                                     @RequestParam(value = "userId") Integer userId){
        ServerResponse response = deviceStatusService.takeReturn(deviceId, deviceTypeId, status, userId);
        return response;
    }

    @RequestMapping("/getDeviceUsers")
    public ServerResponse getDeviceUsers(){
        ServerResponse response = deviceUserService.getDeviceUsers();
        return response;
    }

    @RequestMapping("/findAll")
    public LayuiTableResponse findAll(@RequestParam(value = "pageSize", defaultValue = "10") String pageSize,
                                      @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                      DeviceStatus deviceStatus){
        deviceStatus = deviceStatus.toNull(deviceStatus);
        ServerResponse<PageInfo> response = deviceStatusService.findAll(deviceStatus, Integer.parseInt(pageSize), pageNum);
        LayuiTableResponse layuiTableResponse = response.parseToLayuiTableResponse(response);
        return layuiTableResponse;
    }

    @RequestMapping("/repair")
    public LayuiTableResponse find(@RequestParam(value = "pageSize", defaultValue = "10") String pageSize,
                                   @RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                   DeviceRepair deviceRepair){
        deviceRepair = deviceRepair.toNull(deviceRepair);
        ServerResponse<PageInfo> response = deviceStatusService.findRepair(deviceRepair, Integer.parseInt(pageSize), pageNum);
        LayuiTableResponse layuiTableResponse = response.parseToLayuiTableResponse(response);
        return layuiTableResponse;
    }

    @RequestMapping("/easyui/repair")
    public EasyuiTableResponse findB(@RequestParam(value = "rows", defaultValue = "10") String pageSize,
                                     @RequestParam(value = "page", defaultValue = "1")int pageNum,
                                     DeviceRepair deviceRepair, HttpServletRequest request){
        deviceRepair = deviceRepair.toNull(deviceRepair);
        ServerResponse<PageInfo> response = deviceStatusService.findRepair(deviceRepair, Integer.parseInt(pageSize), pageNum);
        EasyuiTableResponse easyuiTableResponse = response.parseToEasyuiTableResponse(response);
        return easyuiTableResponse;
    }

    @RequestMapping("/easyui/repairAll")
    public EasyuiTableResponse findC(@RequestParam(value = "rows", defaultValue = "1000000000") String pageSize,
                                     @RequestParam(value = "page", defaultValue = "1")int pageNum,
                                     DeviceRepair deviceRepair, HttpServletRequest request){
        deviceRepair = deviceRepair.toNull(deviceRepair);
        ServerResponse<PageInfo> response = deviceStatusService.findRepair(deviceRepair, Integer.parseInt(pageSize), pageNum);
        EasyuiTableResponse easyuiTableResponse = response.parseToEasyuiTableResponse(response);
        return easyuiTableResponse;
    }

    @RequestMapping("/updateRepair")
    public ServerResponse updateRepair(DeviceRepair deviceRepair){
        return deviceStatusService.updateRepair(deviceRepair);
    }


    /**
     * 设备报修
     * @param deviceRepair
     * @param session
     * @return
     */
    @RequestMapping("/addRepair")
    public ServerResponse addRepair(DeviceRepair deviceRepair, HttpSession session){
        Login user = (Login) session.getAttribute(Constant.CURRENT_USER);
        String openId = (String) session.getAttribute(Constant.OPENID);
        if(user != null) {
            deviceRepair.setDeviceId(deviceRepair.getDeviceId().toUpperCase());
            deviceRepair.setDeviceUserId(user.getId());
            return deviceRepairService.addRepair(deviceRepair);
        }else if(StringUtils.isNotEmpty(openId)){
            return ServerResponse.createByErrorMessage("报修成功" + openId);
        }else {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
    }


}
