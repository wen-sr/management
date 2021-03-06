package com.management.schedule;

import com.management.common.Constant;
import com.management.dao.device.DeviceLikuFaultMapper;
import com.management.dao.info.OnOffMapper;
import com.management.dao.liku.BankShuttleMapper;
import com.management.pojo.device.DeviceLikuFault;
import com.management.pojo.prd1.WmsErrorMsg;
import com.management.pojo.wechat.UserInfo;
import com.management.service.prd1.IWmsErrorMsgService;
import com.management.service.wechat.IUserInfoService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.vo.liku.ErrorMessageVo;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import oracle.jdbc.driver.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Autowired
    BankShuttleMapper bankShuttleMapper;

    @Autowired
    OnOffMapper onOffMapper;

    @Autowired
    DeviceLikuFaultMapper deviceLikuFaultMapper;
//    @Scheduled(cron="0/5 * * * * ? ") //间隔5秒执行
    @Scheduled(cron="0 0/5 * * * ? ") //间隔5分钟执行
    public void ErrorMsg(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        String info = onOffMapper.getFlagByName(Constant.INFO);
        if("1".equals(info)){
            wmsError();
        }
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        String liku = onOffMapper.getFlagByName(Constant.LIKU);
        if("1".equals(liku)){
            likuError();
        }
    }

    //wms报错
    private void wmsError(){
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
    //立库报错
    private void likuError(){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_LIKU);
        //logger.info("<<<---------查询WMS系统报错信息的定时任务开始--------->>>");
        List<ErrorMessageVo>  errorMessageVoList = bankShuttleMapper.getErrorMsg();
        if(errorMessageVoList != null && errorMessageVoList.size() > 0){
            if(errorMessageVoList.size() > 10) {
                return;
            }
            List<DeviceLikuFault> deviceLikuFaultList = new ArrayList<>();
            DeviceLikuFault d = null;
            for(ErrorMessageVo emv : errorMessageVoList) {
                d = new DeviceLikuFault();
                d.setBandId(emv.getBankId());
                d.setErrorCode(emv.getErrorCode());
                d.setErrorMsg(emv.getErrorMsg());
                d.setName(emv.getName());
                deviceLikuFaultList.add(d);
            }
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
            for(DeviceLikuFault dd : deviceLikuFaultList) {
                deviceLikuFaultMapper.insertSelective(dd);
            }
            List<UserInfo> userInfoList = findByroleId(Constant.Role.ROLE_JSY);
            for(ErrorMessageVo e : errorMessageVoList){
                for(UserInfo userInfo : userInfoList){
                    WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
//                            .toUser("oPOAgvx1Utuu0Mg25QTPs5yqDUyw")
                            .toUser(userInfo.getOpenid())
                            .templateId("3NNDKh-IQwR4vV8hbv3AY1J1hFEtkrU3MwbXtY3L8dU").build();
                    templateMessage.getData().add(new WxMpTemplateData("first", "您好，您有一条立库故障通知！", "#284177"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword1", e.getName(), "#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword2", DateTimeUtil.dateToStr(new Date()), "#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("keyword3", e.getBankId() + "号立库，" + e.getName() + e.getErrorMsg() + "， 报错代码：" + e.getErrorCode(),"#0044BB"));
                    templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流技术部", "#AAAAAA"));
                    templateMessage.setUrl("http://www.jxxh56.com/management/page/infor/messageShow.html");

                    try {
                        wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                    } catch (WxErrorException ex) {
                        ex.printStackTrace();
                        logger.error("=====微信发送系统故障提醒时报错=====",ex);
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
