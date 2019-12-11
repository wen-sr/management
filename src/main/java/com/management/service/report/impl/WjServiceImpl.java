package com.management.service.report.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ResponseCode;
import com.management.dao.report.LipsJobsXsoMapper;
import com.management.service.report.IWjService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.lipsJobsXso.WjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WjServiceImpl implements IWjService {
    @Autowired
    LipsJobsXsoMapper lipsJobsXsoMapper;
    @Override
    public EasyuiTableResponse wj(WjVo wjVo){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_TRANSIT);
        List<WjVo> wjList = lipsJobsXsoMapper.wj(wjVo);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(wjList);
        return response;
    }
}
