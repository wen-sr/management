package com.management.service.jc.impl;

import com.management.common.ServerResponse;
import com.management.dao.jc.JiaoCaiPackMapper;
import com.management.pojo.jc.JiaoCaiPack;
import com.management.service.jc.IJiaoCaiPackService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/1/22 12:44
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiPackServiceImpl implements IJiaoCaiPackService {

    @Autowired
    JiaoCaiPackMapper jiaoCaiPackMapper;

    @Override
    public ServerResponse findAll(JiaoCaiPack jiaoCaiPack) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiPack> jiaoCaiPackList = jiaoCaiPackMapper.findAll(jiaoCaiPack);
        return ServerResponse.createBySuccess(jiaoCaiPackList);
    }

    @Override
    public ServerResponse add(JiaoCaiPack jiaoCaiPack) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = jiaoCaiPackMapper.insertSelective(jiaoCaiPack);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("添加捆扎成功");
        }else {
            return ServerResponse.createByErrorMessage("添加捆扎失败");
        }
    }

    @Override
    public ServerResponse delete(JiaoCaiPack jiaoCaiPack) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = jiaoCaiPackMapper.deleteByPrimaryKey(jiaoCaiPack);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("删除捆扎成功");
        }else {
            return ServerResponse.createByErrorMessage("删除捆扎失败");
        }
    }

    @Override
    public ServerResponse update(JiaoCaiPack jiaoCaiPack) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        int i = jiaoCaiPackMapper.updateById(jiaoCaiPack);
        if(i > 0 ){
            return ServerResponse.createBySuccessMsg("修改捆扎成功");
        }else {
            return ServerResponse.createByErrorMessage("修改捆扎失败");
        }
    }
}
