package com.management.service.led.impl;

import com.management.common.ServerResponse;
import com.management.dao.led.ZhuPeiLedMapper;
import com.management.pojo.led.ZhuPeiLed;
import com.management.pojo.led.ZhuPeiZongBiao;
import com.management.service.led.ZhuPeiLedService;
import com.management.util.DataSourceContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZhuPeiLedServiceImpl implements ZhuPeiLedService {

    @Autowired
    ZhuPeiLedMapper zhuPeiLedMapper;

    @Override

    public ServerResponse getZhuPeiLedData() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WES);
        List<ZhuPeiLed> zhuPeiLedList = zhuPeiLedMapper.getZhuPeiLedData();

        List<ZhuPeiZongBiao> zhuPeiZongBiaoList = zhuPeiLedMapper.getZhuPeiZongBiaoData();

        Map<String, Object> map = new HashMap<>();
        map.put("zhuPeiLedList", zhuPeiLedList);
        map.put("zhuPeiZongBiaoList", zhuPeiZongBiaoList);

        return ServerResponse.createBySuccess(map);
    }
}
