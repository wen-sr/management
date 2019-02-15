package com.management.service.jc.impl;

import com.management.dao.jc.JiaoCaiPrintMapper;
import com.management.service.jc.IJiaoCaiPrintService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.jc.JiaoCaiComputeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/2/15 9:27
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_wms",readOnly = false)
public class JiaoCaiPrintServiceImpl implements IJiaoCaiPrintService {

    @Autowired
    JiaoCaiPrintMapper jiaoCaiPrintMapper;

    @Override
    public Map<String, Object> wholeCaseList(String batchno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.getWholeCaseListHead(batchno);
        List<JiaoCaiComputeVo> detail = jiaoCaiPrintMapper.getWholeCaseListDetail(batchno);
        Map<String, Object> map = new HashMap<>();
        if(head != null && head.size() > 0 ){
            map.put("dt", head);
            map.put("mx", detail);
            return map;
        }
        return null;
    }

    @Override
    public Map<String, Object> allocationList(String batchno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> list = jiaoCaiPrintMapper.getAllocationList(batchno);
        Map<String, Object> map = new HashMap<String, Object>();
        if(list != null && list.size() > 0){
            map.put("list", list);
            map.put("batchno", batchno);
            return map;
        }
        return null;
    }

    @Override
    public Map<String, Object> s_ticketList(String batchno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        Map<String, Object> map = new HashMap<String, Object>();
        List<JiaoCaiComputeVo> list = jiaoCaiPrintMapper.getS_ticketList(batchno);
        map.put("list", list);
        return map;
    }

    @Override
    public Map<String, Object> pickList(String pickno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.getPickListHead(pickno);
        List<JiaoCaiComputeVo> detail = jiaoCaiPrintMapper.getPickListDetail(pickno);
        Map<String, Object> map = new HashMap<String, Object>();
        if(head != null && head.size() > 0 ){
            map.put("dt", head.get(0));
            map.put("mx", detail);
            return map;
        }
        return null;
    }

    @Override
    public Map<String, Object> oddCaseList(String batchno) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_WMS);
        List<JiaoCaiComputeVo> detail = jiaoCaiPrintMapper.getOddCaseList(batchno);
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.getOddCaseListHead(batchno);
        Map<String, Object> map = new HashMap<String, Object>();
        if(head != null && head.size() > 0 ){
            map.put("dt", head);
            map.put("mx", detail);
            return map;
        }
        return null;
    }

    @Override
    public JiaoCaiComputeVo oddTicketList(String batchno) {
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.getOddCaseListHead(batchno);
        if(head != null && head.size() > 0){
            return head.get(0);
        }
        return null;
    }

    @Override
    public List<JiaoCaiComputeVo> loadBatchno() {
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.loadBatchno();
        if(head != null && head.size() > 0){
            return head;
        }
        return null;
    }

    @Override
    public List<JiaoCaiComputeVo> loadPickno() {
        List<JiaoCaiComputeVo> head = jiaoCaiPrintMapper.loadPickno();
        if(head != null && head.size() > 0){
            return head;
        }
        return null;
    }
}
