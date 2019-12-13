package com.management.service.led.impl;


import com.management.common.ServerResponse;
import com.management.dao.led.BaoZhuangLedMapper;
import com.management.pojo.led.BaoZhuangLed;
import com.management.service.led.BaoZhuangLedService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaoZhuangLedServiceImpl implements BaoZhuangLedService {

    @Autowired
    BaoZhuangLedMapper baoZhuangLedMapper;


    @Override
    public ServerResponse getBaoZhuangLedData() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<BaoZhuangLed> baoZhuangLedList = baoZhuangLedMapper.getBaoZhuangLedData();
        return ServerResponse.createBySuccess(baoZhuangLedList);
    }
}
