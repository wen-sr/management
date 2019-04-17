package com.management.service.jxlh56.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.management.common.Constant;
import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.dao.jxlh56.NoticeMapper;
import com.management.dao.wechat.UserInfoMapper;
import com.management.pojo.busi.BusiMessageWx;
import com.management.pojo.jxlh56.News;
import com.management.pojo.jxlh56.Notice;
import com.management.pojo.wechat.UserInfo;
import com.management.service.jxlh56.INoticeService;
import com.management.util.DataSourceContextHolder;
import com.management.util.DateTimeUtil;
import com.management.util.WechatMaterialUtil;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/17 13:36
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_jxlh56",readOnly = false)
public class NoticeServiceImpl implements INoticeService {

    private final static Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    WxMpService wxMpService;

    @Override
    public EasyuiTableResponse queryInfo(Integer pageSize, Integer pageNum, Notice news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);

        PageHelper.startPage(pageNum,pageSize);
        List<News> noticeList = noticeMapper.findAll(news);
        PageInfo pageInfo = new PageInfo(noticeList);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(pageInfo.getList());
        response.setCode(0);
        response.setCount(noticeList.size());
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    @Override
    public ServerResponse queryInfo2(int i, int i1, Notice news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        List<News> newsList = noticeMapper.findAll2();
        return ServerResponse.createBySuccess(newsList);
    }

    @Override
    public ServerResponse queryById(Notice notice) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        News news = noticeMapper.queryById(notice.getId());
        return ServerResponse.createBySuccess(news);
    }

    @Override
    public ServerResponse sendToWechat(List<Integer> ids) {
        List<String> list = new ArrayList<>();
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<UserInfo> userInfoList = userInfoMapper.findAll();
        //for(UserInfo u : userInfoList) {
        //    list.add(u.getOpenid());
        //}
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        News notice = null;
        for(Integer i : ids) {
            notice = noticeMapper.queryById(i);
            sendToWechat(notice, "oPOAgvx1Utuu0Mg25QTPs5yqDUyw");
            notice.setIstochart(2);
        }
        noticeMapper.updateStatus(ids);
        return ServerResponse.createBySuccessMsg("发送成功");
    }

    private void sendToWechat(News notice, String openid){
        if(notice == null ){
            return;
        }
        String msg = "公告：" + notice.getTitle();
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openid)
                .templateId("j3uSiEeYMGG1UrMmU_AZlIJ_xwdTChiCGkKCpbTr2sk").build();
        templateMessage.getData().add(new WxMpTemplateData("first", msg, "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", "江西蓝海物流", "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("keyword2", DateTimeUtil.dateToStr(new Date()), "#0044BB"));
        templateMessage.getData().add(new WxMpTemplateData("remark", "江西蓝海物流科技有限公司", "#AAAAAA"));
        templateMessage.setUrl("http://www.jxxh56.com/management/page/wechat/announcement/announcementDetail.html?noticeId=" + notice.getId());
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.error("=====微信发送系统故障提醒时报错=====",e);
        }
    }
}
