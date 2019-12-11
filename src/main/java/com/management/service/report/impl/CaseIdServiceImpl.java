package com.management.service.report.impl;


import com.management.common.EasyuiTableResponse;
import com.management.common.ResponseCode;
import com.management.dao.report.CaseIdMapper;
import com.management.service.report.ICaseIdService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.caseid.WeiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CaseIdServiceImpl implements ICaseIdService {
    @Autowired
    CaseIdMapper caseIdMapper;

    @Override
    public EasyuiTableResponse getCaseIdData(String date_begin, String date_end, String type){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<WeiVo> caseIdList = caseIdMapper.getCaseIdData(date_begin,date_end, type);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setRows(caseIdList);
        return response;
    }

}
