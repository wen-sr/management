package com.management.service.wcs.impl;

import com.management.dao.wcs.TaskOpsMapper;
import com.management.pojo.wcs.TaskOps;
import com.management.service.wcs.ITaskOpsService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/13 20:13
 * Modified By：
 */
@Service
public class TaskOpsServiceImpl implements ITaskOpsService {
    @Autowired
    TaskOpsMapper taskOpsMapper;


    @Override
    public List<TaskOps> selectByConnbr(String connbr) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        return taskOpsMapper.selectByConnbr(connbr);
    }
}
