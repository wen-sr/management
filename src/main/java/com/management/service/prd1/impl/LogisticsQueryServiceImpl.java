package com.management.service.prd1.impl;

import com.management.common.ServerResponse;
import com.management.dao.prd1.XsogroupMapper;
import com.management.service.prd1.ILogisticsQueryService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.prd1.LogisticsQueryVo;
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
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<LogisticsQueryVo> logisticsQueryVoList = xsogroupMapper.bookShip(logisticsQueryVo);
        return ServerResponse.createBySuccess("", logisticsQueryVoList);
    }
}
