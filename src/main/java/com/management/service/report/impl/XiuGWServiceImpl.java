package com.management.service.report.impl;

import com.management.common.ServerResponse;
import com.management.dao.report.CaseDetailMapper;
import com.management.dao.report.CaseIdMapper;
import com.management.dao.report.JobscontextXsoMapper;
import com.management.service.report.IXiuGWService;
import com.management.util.DataSourceContextHolder;
import com.management.vo.xgw.XgwVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "transactionManager_prd1",readOnly = false)
public class XiuGWServiceImpl implements IXiuGWService {
    @Autowired
    JobscontextXsoMapper jobscontextXsoMapper;
    @Autowired
    CaseDetailMapper caseDetailMapper;
    @Autowired
    CaseIdMapper caseIdMapper;
    @Override
    public ServerResponse cx(XgwVo xgwVo){
        DataSourceContextHolder.setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        List<XgwVo> XgwVoList = jobscontextXsoMapper.cx(xgwVo);
        int sumkd = 0;
        int sumss = 0;
        int sumcy=0;
        double sumcym=0;
        for(XgwVo x : XgwVoList) {
            sumkd += x.getKd();
            sumss += x.getSs();
            sumcy += x.getCy();
            sumcym += x.getCym();
        }
        XgwVo xx = new XgwVo();
        xx.setBarcode("总计");
        xx.setKd(sumkd);
        xx.setCy(sumcy);
        xx.setSs(sumss);
        xx.setCym(sumcym);
        XgwVoList.add(xx);
        if(XgwVoList != null && XgwVoList.size() > 0) {
            XgwVo xgwVo1 = new XgwVo();
            xgwVo1.setDoc_number(XgwVoList.get(0).getDoc_number());
            xgwVo1.setConsk(XgwVoList.get(0).getConsk());
            xgwVo1.setDoc_shortname(XgwVoList.get(0).getDoc_shortname());
            xgwVo1.setXgwVoList(XgwVoList);
            return ServerResponse.createBySuccess("查询成功", xgwVo1);
        }
        return ServerResponse.createByErrorMessage("无数据");
    }
    @Override
    public ServerResponse go(XgwVo xgwVo) {
        jobscontextXsoMapper.go(xgwVo);
        return null;
    }
    @Override
    public ServerResponse go1(XgwVo xgwVo) {
        jobscontextXsoMapper.go1(xgwVo);
        return null;
    }
    @Override
    public ServerResponse go2(XgwVo xgwVo) {
        jobscontextXsoMapper.go2(xgwVo);
        return null;
    }

}
