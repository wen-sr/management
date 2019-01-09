package com.management.service.prd1.impl;

import com.management.common.ServerResponse;
import com.management.dao.prd1.XsogroupMapper;
import com.management.service.prd1.ISkuService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.RecordSkuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkuServiceImp implements ISkuService {

    @Autowired
    XsogroupMapper xsogroupMapper;

    @Override
    public ServerResponse getSkuByBarcode(String barcode) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<RecordSkuDto> skuList = xsogroupMapper.selectByBarcode(barcode);
        if(skuList != null && skuList.size() > 0){
            return ServerResponse.createBySuccess(skuList);
        }
        return null;
    }
}
