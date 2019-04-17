package com.management.service.busi.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.RequestHolder;
import com.management.common.ServerResponse;
import com.management.dao.busi.BusiMessageWxMapper;
import com.management.dao.busi.SendOpenidListMapper;
import com.management.pojo.busi.BusiMessageWx;
import com.management.pojo.busi.SendOpenidList;
import com.management.service.busi.IBusiMessageWxService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/15 13:12
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_xh",readOnly = false)
public class BusiMessageWxServiceImpl implements IBusiMessageWxService {
    private final static Logger logger = LoggerFactory.getLogger(BusiMessageWxServiceImpl.class);

    @Autowired
    BusiMessageWxMapper busiMessageWxMapper;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    SendOpenidListMapper sendOpenidListMapper;

    @Override
    public ServerResponse queryInfo(Integer pageSize, Integer pageNum, BusiMessageWx busiMessageWx) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        PageHelper.startPage(pageNum,pageSize);

        List<BusiMessageWx> busiMessageWxList = busiMessageWxMapper.selectAll(busiMessageWx);

        PageInfo pageInfo = new PageInfo(busiMessageWxList);

        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse addInfo(BusiMessageWx busiMessageWx) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<BusiMessageWx> busiMessageWxList = busiMessageWxMapper.selectAll(busiMessageWx);
        if(busiMessageWxList != null && busiMessageWxList.size() > 0 ){
            return ServerResponse.createByErrorMessage("您已经添加过，请勿重复添加");
        }

        busiMessageWx.setAddwho(RequestHolder.getCurrentUser().getName());
        busiMessageWxMapper.insertSelective(busiMessageWx);

        List<SendOpenidList> sendOpenidList = sendOpenidListMapper.selectByType("busi");
        for(SendOpenidList s : sendOpenidList) {
            sendToWechat(busiMessageWx, s.getOpenid());
        }

        return ServerResponse.createBySuccessMsg("添加成功");
    }

    @Override
    public ServerResponse queryInfo2(BusiMessageWx busiMessageWx) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<BusiMessageWx> busiMessageWxList = busiMessageWxMapper.selectAll(busiMessageWx);
        return ServerResponse.createBySuccess(busiMessageWxList);
    }

    private void sendToWechat(BusiMessageWx busiMessageWx, String openid){
        if(busiMessageWx == null ){
            return;
        }
        String msg = "业务部南昌仓电商发货今日产量：今日收货："+ busiMessageWx.getQtyReceiptDay() +"；累计收货：" + busiMessageWx.getQtyReceiptMouth() +
                "；今日发货：" + busiMessageWx.getQtyDeliveryDay() + "；累计发货：" + busiMessageWx.getQtyDeliveryMouth() + "；库存：" + busiMessageWx.getQtyStock();
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openid)
                .templateId("j3uSiEeYMGG1UrMmU_AZlIJ_xwdTChiCGkKCpbTr2sk").build();
        templateMessage.getData().add(new WxMpTemplateData("first", msg, "#FF3333"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", "业务部", "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("keyword2", DateTimeUtil.dateToStr(new Date()), "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流", "#AAAAAA"));
        templateMessage.setUrl("http://www.jxxh56.com/management/page/busi/messageShow.html?id=" + busiMessageWx.getId());
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.error("=====微信发送系统故障提醒时报错=====",e);
        }
    }

}
