package com.management.service.jc.impl;

import com.management.dao.jc.JiaoCaiContainerLocMapper;
import com.management.pojo.jc.JiaoCaiContainerLoc;
import com.management.service.jc.IJiaoCaiContainerLocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/26 10:14
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiContainerLocServiceImpl implements IJiaoCaiContainerLocService {

    @Autowired
    JiaoCaiContainerLocMapper jiaoCaiContainerLocMapper;

    @Override
    public void setLoc(String containerId, String loc){
        JiaoCaiContainerLoc jiaoCaiContainerLoc = jiaoCaiContainerLocMapper.selectByPrimaryKey(containerId);
        if(jiaoCaiContainerLoc.getLoc() == null){
            jiaoCaiContainerLoc.setLoc(loc);
            jiaoCaiContainerLoc.setContainerId(containerId);
            jiaoCaiContainerLocMapper.insertSelective(jiaoCaiContainerLoc);
        }else {
            jiaoCaiContainerLoc.setLoc(loc);
            jiaoCaiContainerLocMapper.updateByPrimaryKeySelective(jiaoCaiContainerLoc);
        }
    }
    @Override
    public JiaoCaiContainerLoc getLoc(String containerId) {
        return jiaoCaiContainerLocMapper.selectByPrimaryKey(containerId);

    }
}
