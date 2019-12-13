package com.management.service.led.impl;


import com.management.common.ServerResponse;
import com.management.dao.led.ShangJiaRKLedMapper;
import com.management.dao.led.ZanCunRkLedMapper;
import com.management.service.led.ShangJiaRKLedService;
import com.management.service.led.ZanCunRKLedService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.led.SumAndCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZanCunRKLedServiceImpl implements ZanCunRKLedService {

    @Autowired
    ShangJiaRKLedService shangJiaRKLedService;

    @Autowired
    ShangJiaRKLedMapper shangJiaRKLedMapper;

    @Autowired
    ZanCunRkLedMapper zanCunRkLedMapper;

    @Override
    public ServerResponse getTuoPan4LedData() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        Integer complete_ZanCunRK = zanCunRkLedMapper.getComplete();
        Integer incomplete_ZanCunRK = zanCunRkLedMapper.getIncomplete();

        SumAndCount incomplete_ShangJiaRK = shangJiaRKLedMapper.getIncomplete();
        if(incomplete_ShangJiaRK == null){
            incomplete_ShangJiaRK = new SumAndCount();
        }
        SumAndCount complete_ShangJiaRK = shangJiaRKLedMapper.getComplete();
        if(complete_ShangJiaRK == null){
            complete_ShangJiaRK = new SumAndCount();
        }

        SumAndCount totalToday_case = shangJiaRKLedMapper.getTotalTodayCase();
        if(totalToday_case == null){
            totalToday_case = new SumAndCount();
        }
        SumAndCount complete_case = shangJiaRKLedMapper.getCompleteCase();
        if(complete_case == null){
            complete_case = new SumAndCount();
        }
        SumAndCount incomplete_PK = shangJiaRKLedMapper.getIncompletePK();
        if(incomplete_PK == null){
            incomplete_PK = new SumAndCount();
        }
        SumAndCount complete_PK = shangJiaRKLedMapper.getCompletePK();
        if(complete_PK == null){
            complete_PK = new SumAndCount();
        }

        Integer incomplete_ZanCunCK = shangJiaRKLedMapper.getIncompleteZanCunCK();
        Integer complete_ZanCunCK = shangJiaRKLedMapper.getCompleteZanCunCK();
        SumAndCount complete_buHuo = shangJiaRKLedMapper.getcompleteBuHuoData();
        if(complete_buHuo == null){
            complete_buHuo = new SumAndCount();
        }
        SumAndCount incomplete_buHuo = shangJiaRKLedMapper.getIncompleteBuHuoData();
        if(incomplete_buHuo == null){
            incomplete_buHuo = new SumAndCount();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("incomplete_ZanCunRK", incomplete_ZanCunRK);
        map.put("complete_ZanCunRK", complete_ZanCunRK);

        map.put("incomplete_ShangJiaRK", incomplete_ShangJiaRK);
        map.put("complete_ShangJiaRK", complete_ShangJiaRK);

        map.put("totalToday_case", totalToday_case);
        map.put("complete_case", complete_case);

        map.put("incomplete_PK", incomplete_PK);
        map.put("complete_PK", complete_PK);

        map.put("incomplete_ZanCunCK", incomplete_ZanCunCK);
        map.put("complete_ZanCunCK", complete_ZanCunCK);

        map.put("complete_BuHuo", complete_buHuo);
        map.put("incomplete_BuHuo", incomplete_buHuo);



        return ServerResponse.createBySuccess(map);
    }
}
