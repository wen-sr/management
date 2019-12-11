package com.management.service.report.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ResponseCode;
import com.management.common.ServerResponse;
import com.management.dao.report.TaskCaseMapper;
import com.management.pojo.report.TaskCase;
import com.management.service.report.ITaskCaseService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.taskCase.QxbVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "transactionManager_prd1",readOnly = false)
public class TaskCaseServiceImpl implements ITaskCaseService {
    @Autowired
    TaskCaseMapper taskCaseMapper;
    @Override
    public EasyuiTableResponse getTaskCaseData(String date_begin, String date_end){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<QxbVo> taskCaseList = taskCaseMapper.getTaskCaseData(date_begin,date_end);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(taskCaseList);
        return response;
    }
    @Override
    public EasyuiTableResponse updateTaskCaseData(TaskCase taskCase){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        int taskCaseList = taskCaseMapper.updateTaskCaseData(taskCase);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(taskCaseList);
        return response;

    }

    @Override
    public ServerResponse updateCaseid(TaskCase taskCase) {
        taskCaseMapper.updateCaseid(taskCase);
        return null;
    }
}
