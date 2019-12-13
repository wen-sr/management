package com.management.service.led.impl;


import com.management.common.ServerResponse;
import com.management.dao.led.PickLedMapper;
import com.management.pojo.led.PickLed;
import com.management.service.led.XiangKuLedService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class XiangKuLedServiceImpl implements XiangKuLedService {

    @Autowired
    PickLedMapper pickLedMapper;

    @Override

    public ServerResponse getXiangKuLedData() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_OPS);
        List<PickLed> pickLedList = pickLedMapper.getPickLedData();
        Map<String, Object> map = new HashMap<>();
        map.put("pick", pickLedList);
        return ServerResponse.createBySuccess(map);
    }
}
