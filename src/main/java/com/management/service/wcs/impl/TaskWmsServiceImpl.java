package com.management.service.wcs.impl;

import com.management.common.ServerResponse;
import com.management.dao.wcs.TaskWmsMapper;
import com.management.pojo.wcs.TaskWms;
import com.management.service.wcs.ITaskWmsService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description: WMS任务
 * DateCrated: 2019/1/13 19:01
 * Modified By：
 */
@Service
public class TaskWmsServiceImpl implements ITaskWmsService {

    @Autowired
    TaskWmsMapper taskWmsMapper;

    @Override
    public List<TaskWms> selectByConnbr(String connbr) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        return taskWmsMapper.selectByConnbr(connbr);
    }

    @Override
    public ServerResponse getTaskWmsData(TaskWms taskWms) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        List<TaskWms> taskWmsList = taskWmsMapper.getTaskWmsData(taskWms);
        return ServerResponse.createBySuccess("查询成功", taskWmsList);

    }
}
