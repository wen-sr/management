package com.management.service.jc.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiStorerMapper;
import com.management.pojo.jc.JiaoCaiStorer;
import com.management.service.jc.IJiaoCaiStorerService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 11:52
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiStorerServiceImpl implements IJiaoCaiStorerService {
    @Autowired
    JiaoCaiStorerMapper jiaoCaiStorerMapper;

    @Override
    public ServerResponse getInfo(Integer pageSize, Integer pageNum, JiaoCaiStorer jiaoCaiStorer) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiStorer> jiaoCaiStorerList = null;

        PageHelper.startPage(pageNum,pageSize);

        jiaoCaiStorerList = jiaoCaiStorerMapper.findAll(jiaoCaiStorer);

        PageInfo pageInfo = new PageInfo(jiaoCaiStorerList);

        return ServerResponse.createBySuccess(pageInfo);
    }
}
