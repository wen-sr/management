package com.management.service.jxlh56.impl;

import com.management.common.EasyuiTableResponse;
import com.management.common.ServerResponse;
import com.management.dao.jxlh56.NewsMapper;
import com.management.pojo.jxlh56.News;
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
import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    WxMpService wxMpService;

    @Override
    public EasyuiTableResponse queryInfo(News news) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        List<News> newsList = newsMapper.findAll();
        EasyuiTableResponse response = new EasyuiTableResponse();
        response.setRows(newsList);
        response.setCode(0);
        response.setCount(newsList.size());
        return response;
    }

    @Override
    public ServerResponse sendToWechat(List<Integer> ids) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_JXLH56);
        List<News> newsList = newsMapper.findByIds(ids);
        WxMpMassNews news = new WxMpMassNews();
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(300000000).setConnectTimeout(300000000).setSocketTimeout(2000000000)
                .build();
        WxMpMassNews.WxMpMassNewsArticle article1 = null;
        for(News n : newsList) {
            String imgPath = "http://img.jxlh56.com/01/7a9b4090-b720-45f2-80bc-7ebf82533dd2.jpg";
            String mediaId = null;
            try {
                mediaId = WechatMaterialUtil.getMediaIdFromUrl(wxMpService, imgPath, "jpg");
            } catch (Exception e) {
                e.printStackTrace();
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
        }

        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(WxConsts.MassMsgType.MPNEWS);
        massMessage.setMediaId(massUploadResult.getMediaId());
        List<String> list = new ArrayList<>();
        //list.add("ogodE5zVenVrCCm04Cn79HgmbaQk");
        list.add("oPOAgvx1Utuu0Mg25QTPs5yqDUyw");
        list.add("oPOAgvzZ8PNdl59hjHVNxwVi6S6c");
        massMessage.setToUsers(list);

        try {
            WxMpMassSendResult massResult = wxMpService.getMassMessageService().massOpenIdsMessageSend(massMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return null;
    }
}
