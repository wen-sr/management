package com.management.service.wcs.impl;

import com.management.common.Constant;
import com.management.common.ServerResponse;
import com.management.dao.wcs.ConfigWcsMapper;
import com.management.pojo.wcs.ConfigWcs;
import com.management.service.wcs.IConfigWcsService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigWcsServiceImpl implements IConfigWcsService {

    @Autowired
    ConfigWcsMapper configWcsMapper;


    @Override
    public ServerResponse selectConfigWcs(String key){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        if(key == null) {
            key = Constant.ConfigWCS.TRANS_MODE_3T4;
        }

        ConfigWcs configWcs = configWcsMapper.selectConfigWcsByParaName(key);
        if(configWcs != null){
            return ServerResponse.createBySuccess(configWcs);
        }
        return ServerResponse.createBySuccessMsg("数据查询失败，请联系管理员");
    }

    @Override
    public ServerResponse updateConfigWcs(String key, String value){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WCS);
        if(key == null) {
            key = Constant.ConfigWCS.TRANS_MODE_3T4;
        }

        int i = configWcsMapper.updateConfigWcsByParaName(key, value);
        if(i > 0){
            return ServerResponse.createBySuccessMsg("修改成功");
        }
        return ServerResponse.createBySuccessMsg("修改失败，请联系管理员");
    }

}
