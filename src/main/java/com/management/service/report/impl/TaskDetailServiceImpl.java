package com.management.service.report.impl;

import com.management.common.ServerResponse;
import com.management.dao.report.PickDetailMapper;
import com.management.dao.report.PickingStationWorkOrderMapper;
import com.management.dao.report.ReplenishmentMapper;
import com.management.dao.report.TaskDetailMapper;
import com.management.service.report.ITaskDetailService;
import com.management.util.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class TaskDetailServiceImpl implements ITaskDetailService {
    @Autowired
    TaskDetailMapper taskDetailMapper;
    @Autowired
    PickDetailMapper pickDetailMapper;
    @Autowired
    ReplenishmentMapper replenishmentMapper;
    @Autowired
    PickingStationWorkOrderMapper pickingStationWorkOrderMapper;

    @Override
    public ServerResponse getQingPeiData(String date_begin, String date_end) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        Map<String, Object> result = new HashMap<>();
//        上架
        Map<String, Integer> map = new HashMap<>();
        int boxUp = taskDetailMapper.getQingPeiData(date_begin,date_end);
        map.put("boxUp",boxUp);
        int boxUpF = taskDetailMapper.getQingPeiData1(date_begin,date_end);
        map.put("boxUpF",boxUpF);
        int boxUpU = taskDetailMapper.getQingPeiData2(date_begin,date_end);
        map.put("boxUpU",boxUpU);
        int trayUpF = taskDetailMapper.getQingPeiData3(date_begin,date_end);
        map.put("trayUpF",trayUpF);
        int trayUpF1 = taskDetailMapper.getQingPeiData25(date_begin,date_end);
        map.put("trayUpF1",trayUpF1);
        int trayUpU = taskDetailMapper.getQingPeiData4(date_begin,date_end);
        map.put("trayUpU",trayUpU);
        int trayUpU1 = taskDetailMapper.getQingPeiData26(date_begin,date_end);
        map.put("trayUpU1",trayUpU1);
        int tfUpF = taskDetailMapper.getQingPeiData5(date_begin,date_end);
        map.put("tfUpF",tfUpF);
        int tfUpU = taskDetailMapper.getQingPeiData6(date_begin,date_end);
        map.put("tfUpU",tfUpU);
        int yxUpF = taskDetailMapper.getQingPeiData7(date_begin,date_end);
        map.put("yxUpF",yxUpF);
        int yxUpU = taskDetailMapper.getQingPeiData8(date_begin,date_end);
        map.put("yxUpU",yxUpU);
        int utF = taskDetailMapper.getQingPeiData9(date_begin,date_end);
        map.put("utF",utF);
        int utU = taskDetailMapper.getQingPeiData10(date_begin,date_end);
        map.put("utU",utU);
        result.put("shangJia", map);
//        拣货
        Map<String, Integer> map1 = new HashMap<>();
        int bpF = pickDetailMapper.getQingPeiData11(date_begin,date_end);
        map1.put("bpF",bpF);
        int bpU = pickDetailMapper.getQingPeiData12(date_begin,date_end);
        map1.put("bpU",bpU);
        int tpF = pickDetailMapper.getQingPeiData13(date_begin,date_end);
        map1.put("tpF",tpF);
        int tpF1 = pickDetailMapper.getQingPeiData23(date_begin,date_end);
        map1.put("tpF1",tpF1);
        int tpU = pickDetailMapper.getQingPeiData14(date_begin,date_end);
        map1.put("tpU",tpU);
        int tpU1 = pickDetailMapper.getQingPeiData24(date_begin,date_end);
        map1.put("tpU1",tpU1);
        int ypF = pickDetailMapper.getQingPeiData15(date_begin,date_end);
        map1.put("ypF",ypF);
        int ypU = pickDetailMapper.getQingPeiData16(date_begin,date_end);
        map1.put("ypU",ypU);
        int qpF = pickDetailMapper.getQingPeiData17(date_begin,date_end);
        map1.put("qpF",qpF);
        int qpF1 = pickDetailMapper.getQingPeiData27(date_begin,date_end);
        map1.put("qpF1",qpF1);
        int qpU = pickDetailMapper.getQingPeiData18(date_begin,date_end);
        map1.put("qpU",qpU);
        int qpU1 = pickDetailMapper.getQingPeiData28(date_begin,date_end);
        map1.put("qpU1",qpU1);
        result.put("jianHuo", map1);

//        补货
        Map<String, Integer> map2 = new HashMap<>();
        int bhF = replenishmentMapper.getQingPeiData19(date_begin, date_end);
        map2.put("bhF", bhF);
        int bhU = replenishmentMapper.getQingPeiData20(date_begin, date_end);
        map2.put("bhU", bhU);
        result.put("buHuo", map2);

//        货阁
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_OPS);
        Map<String, Integer> map3 = new HashMap<>();
         int hsF = pickingStationWorkOrderMapper.getQingPeiData21(date_begin, date_end);
        map3.put("hsF", hsF);
        int hxF = pickingStationWorkOrderMapper.getQingPeiData22(date_begin, date_end);
        map3.put("hxF", hxF);

        result.put("huoGe", map3);

        return ServerResponse.createBySuccess(result);
    }
}


