package com.management.service.wes.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ResponseCode;
import com.management.dao.wes.SalTbShpcdMapper;
import com.management.service.wes.IBxService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.salTbShpcd.BxVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BxServiceImpl implements IBxService {
    @Autowired
    SalTbShpcdMapper salTbShpcdMapper;
    @Override
    public EasyuiTableResponse bx(BxVo bxVo){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_WES);
        List<BxVo> bxList = salTbShpcdMapper.bx(bxVo);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(bxList);
        return response;
    }
}
