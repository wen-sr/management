package com.management.service.led.impl;

import com.management.common.ServerResponse;
import com.management.dao.led.V_view_0002Mapper;
import com.management.service.led.ILedService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LedServiceImpl implements ILedService {

    @Autowired
    V_view_0002Mapper v_view_0002Mapper;

    @Override
    public ServerResponse getLuShunKuData() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        Map<String, Integer> map = new HashMap<>();
        int caseQty1 = v_view_0002Mapper.getLuShunKuData();
        map.put("caseQty1", caseQty1);
        int caseQty2 = v_view_0002Mapper.getLuShunKuData2();
        map.put("caseQty2", caseQty2);
        int caseQty3 = v_view_0002Mapper.getLuShunKuData3();
        map.put("caseQty3", caseQty3);
        int caseQty4 = v_view_0002Mapper.getLuShunKuData4();
        map.put("caseQty4", caseQty4);
        int caseQty5 = v_view_0002Mapper.getLuShunKuData5();
        map.put("caseQty5", caseQty5);
        int caseQty6 = v_view_0002Mapper.getLuShunKuData6();
        map.put("caseQty6", caseQty6);
        int caseQty7 = v_view_0002Mapper.getLuShunKuData7();
        map.put("caseQty7", caseQty7);
        int caseQty8 = v_view_0002Mapper.getLuShunKuData8();
        map.put("caseQty8", caseQty8);
        return ServerResponse.createBySuccess(map);
    }
}
