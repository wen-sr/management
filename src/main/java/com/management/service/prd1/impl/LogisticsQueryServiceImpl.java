package com.management.service.prd1.impl;

import com.management.common.ServerResponse;
import com.management.dao.prd1.XsogroupMapper;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.LogisticsQueryVo;
import com.management.vo.prd1.ReceiptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogisticsQueryServiceImpl implements ILogisticsQueryService {

    @Autowired
    XsogroupMapper xsogroupMapper;

    public ServerResponse bookShipQuery(LogisticsQueryVo logisticsQueryVo){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<LogisticsQueryVo> logisticsQueryVoList = xsogroupMapper.bookShip(logisticsQueryVo);
        return ServerResponse.createBySuccess("", logisticsQueryVoList);
    }

    @Override
    public ServerResponse receiptQuery(ReceiptVo receiptVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        receiptVo.setStorerkey("g01260");
        List<ReceiptVo> receiptVoList = xsogroupMapper.receiptQuery(receiptVo);
        return ServerResponse.createBySuccess(receiptVoList);
    }

    @Override
    public ServerResponse registerDetail(ReceiptVo receiptVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<ReceiptVo> receiptVoList = xsogroupMapper.registerDetail(receiptVo);
        return ServerResponse.createBySuccess(receiptVoList);
    }

    @Override
    public ServerResponse differenceDetail(ReceiptVo receiptVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<ReceiptVo> receiptVoList = xsogroupMapper.differenceDetail(receiptVo);
        return ServerResponse.createBySuccess(receiptVoList);
    }

    @Override
    public ServerResponse rejectDetail(ReceiptVo receiptVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<ReceiptVo> receiptVoList = xsogroupMapper.rejectDetail(receiptVo);
        return ServerResponse.createBySuccess(receiptVoList);
    }
}
