package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.AllowAllocateMapper;
import com.management.pojo.jc.AllowAllocate;
import com.management.service.jc.IAllowAllocateService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/30 12:36
 * Modified By：
 */
@Service
public class AllowAllocateServiceImpl implements IAllowAllocateService {
    @Autowired
    AllowAllocateMapper allowAllocateMapper;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, AllowAllocate allowAllocate) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<AllowAllocate> allowAllocateList = null;
        PageHelper.startPage(pageNum,pageSize);

        allowAllocateList = allowAllocateMapper.findAll(allowAllocate);

        PageInfo pageInfo = new PageInfo(allowAllocateList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
