package com.management.schedule;

import com.management.pojo.prd1.WmsErrorMsg;
import com.management.service.prd1.IWmsErrorMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestSchedule {
    private final static Logger logger = LoggerFactory.getLogger(TestSchedule.class);

    @Autowired
    IWmsErrorMsgService wmsErrorMsgService;


//    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行
    @Scheduled(cron="0 0/2 * * * ? ") //间隔5秒执行
    public void wmsErrorMsg(){
        logger.info("<<<---------查询WMS系统报错信息的定时任务开始--------->>>");
        List<WmsErrorMsg>  wmsErrorMsgList = wmsErrorMsgService.selectAll();
        if(wmsErrorMsgList != null && wmsErrorMsgList.size() > 0){

        }

        logger.info("<<<---------查询WMS系统报错信息的定时任务结束--------->>>");
    }
}
