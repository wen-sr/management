package com.management.service.wcs.impl;

import com.management.common.ServerResponse;
import com.management.dao.wcs.TaskCarMapper;
import com.management.pojo.wcs.TaskCar;
import com.management.service.wcs.ITaskCarService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCarServiceImpl implements ITaskCarService {

    @Autowired
    TaskCarMapper taskCarMapper;

    @Override
    public ServerResponse updateStatus(TaskCar taskCar) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        String status = selectByBoxno(taskCar);
        if(status == null){
            return ServerResponse.createByErrorMessage("您所查询的箱号【"+ taskCar.getContainercode() +"】没有对应的小车任务");
        }
        int i = taskCarMapper.updateStatus(taskCar);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("您所查询的箱号【"+ taskCar.getContainercode() +"】对应的小车任务已经重发成功");
        }
        return ServerResponse.createBySuccessMsg("您所查询的箱号【"+ taskCar.getContainercode() +"】对应的小车任务重发失败");
    }

    @Override
    public List<TaskCar> selectByContainerCode(String containerCode) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        return taskCarMapper.selectByContainerCode(containerCode);
    }

    public String selectByBoxno(TaskCar taskCar) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        taskCar.setContainercode(taskCar.getContainercode().substring(1));
        return taskCarMapper.selectByBoxno(taskCar);
    }

}
