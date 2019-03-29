package com.management.service.prd1.impl;

import com.management.dao.prd1.WmsErrorMsgMapper;
import com.management.pojo.prd1.WmsErrorMsg;
import com.management.schedule.TaskSchedule;
import com.management.service.prd1.IWmsErrorMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IWmsErrorMsgServiceImpl implements IWmsErrorMsgService {
    private final static Logger logger = LoggerFactory.getLogger(TaskSchedule.class);

    @Autowired
    WmsErrorMsgMapper wmsErrorMsgMapper;


    @Override
    public List<WmsErrorMsg> selectAll() {
        return wmsErrorMsgMapper.selectAll();
    }

    @Override
    public void updateFlage(WmsErrorMsg wmsErrorMsg) {
        int i = wmsErrorMsgMapper.updateFlage(wmsErrorMsg);
        if(i > 0 ){
            logger.info("=============成功修改if_key="+ wmsErrorMsg.getIfKey() + "报错信息的flag为1,修改的记录条数为："+ i +"==============");
        }
    }

    @Override
    public void updateHis() {
        int i = wmsErrorMsgMapper.updateHis();
        if(i > 0 ){
            logger.info("=============成功修改历史任务报错信息的flag为1,修改的记录条数为："+ i +"==============");
        }
    }
}
