package com.management.schedule;

import com.management.common.Constant;
import com.management.pojo.prd1.WmsErrorMsg;
import com.management.pojo.wechat.UserInfo;
import com.management.service.prd1.IWmsErrorMsgService;
import com.management.service.wechat.IUserInfoService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class TaskSchedule {
    private final static Logger logger = LoggerFactory.getLogger(TaskSchedule.class);

    @Autowired
    IWmsErrorMsgService wmsErrorMsgService;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    IUserInfoService userInfoService;


//    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行
    @Scheduled(cron="0 0/2 * * * ? ") //间隔2分钟执行
    public void wmsErrorMsg(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        //logger.info("<<<---------查询WMS系统报错信息的定时任务开始--------->>>");
        wmsErrorMsgService.updateHis();
        List<WmsErrorMsg>  wmsErrorMsgList = wmsErrorMsgService.selectAll();
        if(wmsErrorMsgList != null && wmsErrorMsgList.size() > 0){
            List<UserInfo> userInfoList = findByroleId(Constant.Role.ROLE_ADMIN);
            for(WmsErrorMsg wmsErrorMsg : wmsErrorMsgList){
                for(UserInfo userInfo : userInfoList){
                    WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
//                            .toUser("oPOAgvx1Utuu0Mg25QTPs5yqDUyw")
                            .toUser(userInfo.getOpenid())
                            .templateId("3NNDKh-IQwR4vV8hbv3AY1J1hFEtkrU3MwbXtY3L8dU").build();
                    templateMessage.getData().add(new WxMpTemplateData("first", "您好，您有一条系统异常通知！", "#284177"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword1", String.valueOf(wmsErrorMsg.getIfName()), "#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword2", DateTimeUtil.dateToStr(new Date()), "#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword3", "key=" + wmsErrorMsg.getIfKey() + ":" +String.valueOf(wmsErrorMsg.getIfMessage()), "#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流技术部", "#AAAAAA"));
                    try {
                        wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                        wmsErrorMsg.setFlag(new BigDecimal(1));
                        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
                        wmsErrorMsgService.updateFlage(wmsErrorMsg);
                    } catch (WxErrorException e) {
                        e.printStackTrace();
                        logger.error("=====微信发送系统故障提醒时报错=====",e);
                    }
                }

            }
        }
        //logger.info("<<<---------查询WMS系统报错信息的定时任务结束--------->>>");
    }


    public List<UserInfo> findByroleId(int i){
        return userInfoService.findByroleId(i);
    }

}
