package com.management.service.jc.impl;

import com.management.dao.jc.JiaoCaiInventoryMapper;
import com.management.dao.jc.JiaoCaiInventory_detailMapper;
import com.management.pojo.jc.JiaoCaiInventory;
import com.management.pojo.jc.JiaoCaiInventory_detail;
import com.management.service.jc.IJiaoCaiInventoryService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/24 18:53
 * Modified By：
 */
@Service
@Transactional
public class JiaoCaiInventoryServiceImpl implements IJiaoCaiInventoryService {

    @Autowired
    JiaoCaiInventoryMapper jiaoCaiInventoryMapper;

    @Autowired
    JiaoCaiInventory_detailMapper jiaoCaiInventoryDetailMapper;

    @Override
    public int add(JiaoCaiInventory jiaoCaiInventory, JiaoCaiInventory_detail jiaoCaiInventory_detail) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = 0,j = 0;
        if(isExistInventory(jiaoCaiInventory)){
            i += jiaoCaiInventoryMapper.addInventory(jiaoCaiInventory);
        }else {
            i += jiaoCaiInventoryMapper.insertSelective(jiaoCaiInventory);
        }

        jiaoCaiInventory_detail.setLoc("31STAGE");
        if(isExistInventoryDetail(jiaoCaiInventory_detail)){
            j += jiaoCaiInventoryDetailMapper.addInventoryDetail(jiaoCaiInventory_detail);
        }else {
            j += jiaoCaiInventoryDetailMapper.insertSelective(jiaoCaiInventory_detail);
        }

        return i + j;
    }


    private boolean isExistInventory(JiaoCaiInventory jiaoCaiInventory){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiInventory j = jiaoCaiInventoryMapper.selectByIssuenumberAndSubcode(jiaoCaiInventory);
        if(j != null){
            return true;
        }
        return false;
    }

    private boolean isExistInventoryDetail(JiaoCaiInventory_detail jiaoCaiInventory_detail){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        JiaoCaiInventory_detail j = jiaoCaiInventoryDetailMapper.selectByIssuenumberAndSubcodeAndPack(jiaoCaiInventory_detail);
        if(j != null){
            return true;
        }
        return false;

    }
}
