package com.management.service.jxlh56.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.management.aspect.HttpAspect;
import com.management.common.Constant;
import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.dao.jxlh56.NewsMapper;
import com.management.dao.wechat.UserInfoMapper;
import com.management.pojo.jxlh56.News;
import com.management.pojo.wechat.UserInfo;
import com.management.service.jxlh56.INewsService;
import com.management.util.DataSourceContextHolder;
import com.management.util.WechatMaterialUtil;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: wen-sir
 * Description:
 * DateCrated: 2019/4/4 9:28
 * Modified By：
 */
@Service
@Transactional(value = "transactionManager_jxlh56",readOnly = false)
public class NewsServiceImpl implements INewsService {

    private final static Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    WxMpService wxMpService;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public EasyuiTableResponse queryInfo(Integer pageSize, Integer pageNum, News news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);

        PageHelper.startPage(pageNum,pageSize);
        List<News> newsList = newsMapper.findAll(news);
        PageInfo pageInfo = new PageInfo(newsList);
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(pageInfo.getList());
        response.setCode(0);
        response.setCount(newsList.size());
        response.setTotal(pageInfo.getTotal());
        return response;
    }

    @Override
    public ServerResponse sendToWechat(List<Integer> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        List<News> newsList = newsMapper.findByIds(ids);
        WxMpMassNews news = new WxMpMassNews();
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(2000000000).setConnectTimeout(2000000000).setSocketTimeout(2000000000)
                .build();
        WxMpMassNews.WxMpMassNewsArticle article1 = null;
        News n = null;
        for(int i = 0; i < newsList.size(); i++) {
            n = newsList.get(i);
            //String imgPath = "http://img.jxlh56.com/01/00000000-0000-0000-0000-000000000000.png";
            String imgPath = "";
            if(StringUtils.isNotBlank(n.getPictureflie())){
                imgPath = Constant.WEBSITE_PIC + n.getPictureflie();
            }else {
                if(i == 0) {
                    imgPath = "http://img.jxlh56.com/01/00000000-0000-0000-0000-000000000000.png";
                }else {
                    imgPath = "http://img.jxlh56.com/01/00000000-0000-0000-0000-000000000001.png";
                }
            }
            String fileExtensionName = imgPath.substring(imgPath.lastIndexOf(".")+1);
            String mediaId = null;
            try {
                mediaId = WechatMaterialUtil.getMediaIdFromUrl(wxMpService, imgPath, fileExtensionName.toLowerCase());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("微信上传图片素材出错{}", e.getMessage());
            }
            article1 = new WxMpMassNews.WxMpMassNewsArticle();
            article1.setTitle(n.getTitle());
            article1.setContent(n.getNewscontent());
            article1.setShowCoverPic(true);
            article1.setThumbMediaId(mediaId);
            article1.setAuthor(n.getAuthor());
            news.addArticle(article1);
        }
        WxMpMassUploadResult massUploadResult = null;
        try {
            massUploadResult = wxMpService.getMassMessageService().massNewsUpload(news);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.error("微信上传新闻素材出错{}",e.getMessage());
        }

        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(WxConsts.MassMsgType.MPNEWS);
        massMessage.setMediaId(massUploadResult.getMediaId());
        List<String> list = new ArrayList<>();
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<UserInfo> userInfoList = userInfoMapper.findAll();
        //for(UserInfo u : userInfoList) {
        //    list.add(u.getOpenid());
        //}
        list.add("oPOAgvx1Utuu0Mg25QTPs5yqDUyw");
        list.add("oPOAgv82SmlT-lk3IKZIFj8JyfoM");
        list.add("oPOAgvzZ8PNdl59hjHVNxwVi6S6c");
        list.add("oPOAgv1q-glXrkcypnMmPv1iVcVA");
        list.add("oPOAgvxpLfRbjBc8zQMOoHU1OloI");
        massMessage.setToUsers(list);

        try {
            WxMpMassSendResult massResult = wxMpService.getMassMessageService().massOpenIdsMessageSend(massMessage);
            DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
            newsMapper.updateStatus(ids);
        } catch (WxErrorException e) {
            e.printStackTrace();
            logger.error("微信群发新闻出错{}", e.getMessage());
        }

        return ServerResponse.createBySuccessMsg("发送成功");
    }

    @Override
    public ServerResponse queryInfo2(int i, int i1, News news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        List<News> newsList = newsMapper.findAll2();
        return ServerResponse.createBySuccess(newsList);
    }

    @Override
    public ServerResponse queryById(News news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        news = newsMapper.queryById(news.getId());
        return ServerResponse.createBySuccess(news);

    }
}
