package com.management.service.prd1.impl;

import com.management.dao.prd1.WmsErrorMsgMapper;
import com.management.pojo.prd1.WmsErrorMsg;
import com.management.service.prd1.IWmsErrorMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IWmsErrorMsgServiceImpl implements IWmsErrorMsgService {

    @Autowired
    WmsErrorMsgMapper wmsErrorMsgMapper;


    @Override
    public List<WmsErrorMsg> selectAll() {
        return wmsErrorMsgMapper.selectAll();
    }
}
