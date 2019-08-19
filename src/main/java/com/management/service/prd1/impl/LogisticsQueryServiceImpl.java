package com.management.service.prd1.impl;

import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.prd1.XsogroupMapper;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.DeliveryVo;
import com.management.vo.prd1.LogisticsQueryVo;
import com.management.vo.prd1.ReceiptDto;
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
        Login login = RequestHolder.getCurrentUser();
        if(login == null) {
            throw new MyException(10, "未登录");
        }
        receiptVo.setStorerkey(login.getId());
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

    @Override
    public ServerResponse deliveryQuery(DeliveryVo deliveryVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        Login login = RequestHolder.getCurrentUser();
        if(login == null) {
            throw new MyException(10, "未登录");
        }
        deliveryVo.setStorerkey(login.getId());
        List<DeliveryVo> deliveryVoList = xsogroupMapper.deliveryQuery(deliveryVo);
        return ServerResponse.createBySuccess(deliveryVoList);
    }

    @Override
    public ServerResponse orderCaseQuery(DeliveryVo deliveryVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        //Login login = RequestHolder.getCurrentUser();
        //if(login == null) {
        //    throw new MyException(10, "未登录");
        //}
        //deliveryVo.setStorerkey(login.getId());
        List<DeliveryVo> deliveryVoList = xsogroupMapper.orderCaseQuery(deliveryVo);
        return ServerResponse.createBySuccess(deliveryVoList);
    }

    @Override
    public ServerResponse caseidQuery(DeliveryVo deliveryVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        //Login login = RequestHolder.getCurrentUser();
        //if(login == null) {
        //    throw new MyException(10, "未登录");
        //}
        //deliveryVo.setStorerkey(login.getId());
        List<DeliveryVo> deliveryVoList = xsogroupMapper.caseidQuery(deliveryVo);
        return ServerResponse.createBySuccess(deliveryVoList);
    }

    @Override
    public ServerResponse caseSkuDetail(DeliveryVo deliveryVo) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<DeliveryVo> deliveryVoList = xsogroupMapper.caseSkuDetail(deliveryVo);
        return ServerResponse.createBySuccess(deliveryVoList);
    }

    @Override
    public Integer ReceiptQty() {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<ReceiptDto> receiptDtoList = xsogroupMapper.getReceiptToday();
        Integer qty = 0 ;
        for(ReceiptDto r : receiptDtoList) {
            qty += r.getQty();
        }
        return qty;
    }
}
