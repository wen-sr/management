package com.management.service.ops.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ResponseCode;
import com.management.dao.ops.ReContainerPickingShelfOrderMapper;
import com.management.service.ops.IReContainerPickingShelfOrderService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.ops.RPVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReContainerPickingShelfOrderServiceImpl implements IReContainerPickingShelfOrderService {
    @Autowired
    ReContainerPickingShelfOrderMapper reContainerPickingShelfOrderMapper;
    @Override
    public EasyuiTableResponse getReContainerPickingShelfOrderData(String date_begin, String date_end){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_OPS);
        List<RPVo> reContainerPickingShelfOrderList = reContainerPickingShelfOrderMapper.getReContainerPickingShelfOrderData(date_begin,date_end);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(reContainerPickingShelfOrderList);
        return response;
    }

}
