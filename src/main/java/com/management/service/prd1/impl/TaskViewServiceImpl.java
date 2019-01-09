package com.management.service.prd1.impl;

import com.management.common.EasyuiTableResponse;
import com.management.dao.prd1.TaskViewMapper;
import com.management.service.prd1.ITaskViewService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.TaskViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskViewServiceImpl implements ITaskViewService {

    @Autowired
    TaskViewMapper taskViewMapper;

    @Override
    public EasyuiTableResponse getData(TaskViewDto taskView) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<TaskViewDto> taskViewList = taskViewMapper.getData(taskView);
        EasyuiTableResponse response = new EasyuiTableResponse();
        if(taskViewList != null){
            response.setRows(taskViewList);
            response.setCode(0);
            return response;
        }
        response.setCode(1);
        response.setMsg("查询数据失败，请联系管理员");
        return response;
    }
}
