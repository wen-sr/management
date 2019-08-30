package com.management.service.prd1.impl;

import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.prd1.XsogroupMapper;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Override
    public ServerResponse getZhuPeiGouBao(String doc_number) {
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<ZhuPeiGouBaoVo> result = new ArrayList<>();
        List<ZhuPeiGouBaoVo> zhuPeiGouBaoVoList = xsogroupMapper.getZhuPeiGouBao(doc_number);
        if(zhuPeiGouBaoVoList != null && zhuPeiGouBaoVoList.size() > 0){
            Set<String> skuSet = new LinkedHashSet<>();
            for(ZhuPeiGouBaoVo z1 : zhuPeiGouBaoVoList) {
                skuSet.add(z1.getDoc_sku());
            }
            ZhuPeiGouBaoVo zz;
            List<ZhuPeiGouBaoVo> subList;
            for(String s : skuSet) {
                zz = new ZhuPeiGouBaoVo();
                int sumCqty = 0;
                int caseqty = 0;
                ZhuPeiGouBaoVo z;
                zz.setDoc_sku(s);
                subList = new ArrayList<>();
                for(int i = 0; i < zhuPeiGouBaoVoList.size(); i++) {
                    ZhuPeiGouBaoVo z2 = zhuPeiGouBaoVoList.get(i);
                    if(s.equals(z2.getDoc_sku())){
                        if(z2.getDoc_descr()!= null) {
                            zz.setDoc_descr(z2.getDoc_descr());
                        }
                        if(z2.getDoc_number() != null) {
                            zz.setDoc_number(z2.getDoc_number());
                        }
                        if(z2.getDoc_case_qty() != null) {
                            zz.setDoc_case_qty(z2.getDoc_case_qty());
                        }
                        if(z2.getLcs() > (z2.getDoc_case_qty()/2)) {
                            z2.setWbjs(0);
                            z2.setWblcs(z2.getLcs());
                        }else {
                            z2.setWbjs(1);
                            z2.setWblcs(z2.getLcs());
                        }
                        subList.add(z2);
                        sumCqty += z2.getDoc_cqty();
                        caseqty = z2.getDoc_case_qty();
                    }
                }
                z = new ZhuPeiGouBaoVo();
                z.setDoc_consk("小计");
                z.setDoc_cqty(sumCqty);
                z.setDoc_case_qty(caseqty);
                z.setZbs(sumCqty/caseqty);
                z.setLcs(Math.floorMod(sumCqty,caseqty));
                subList.add(z);
                zz.setZhuPeiGouBaoVoList(subList);
                result.add(zz);
            }
        }
        return ServerResponse.createBySuccess(result);
    }
}
