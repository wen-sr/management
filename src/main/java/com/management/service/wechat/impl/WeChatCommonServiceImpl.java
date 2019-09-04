package com.management.service.wechat.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.management.aspect.HttpAspect;
import com.management.common.ServerResponse;
import com.management.dao.login.LoginMapper;
import com.management.dao.prd1.XsogroupMapper;
import com.management.dao.wechat.UserInfoMapper;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.wechat.IWeChatCommonService;
import com.management.util.DataSourceContextHolder;
import com.management.util.MD5Util;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.material.WxMediaImgUploadResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassSendResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class WeChatCommonServiceImpl implements IWeChatCommonService {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    XsogroupMapper xsogroupMapper;

    @Autowired
    WxMpService wxMpService;

    @Override
    public ServerResponse register(Login login) {

        String id = login.getId();
        String pwd = login.getPwd();
        login.setBk2(MD5Util.MD5EncodeUtf8(pwd));
        String name = idIsExist(id, login.getBk5());

        if(StringUtils.isBlank(name)){
            throw new MyException(-1, "您输入的客户代码不存在！");
        }

        if(isRegistered(id, login.getBk5())){
            throw new MyException(-1, "您输入的客户代码已注册！");
        }

        login.setName(name);
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        int i = loginMapper.insertSelective(login);
        if(i > 0){
            return ServerResponse.createBySuccess("注册成功", login);
        }
        return ServerResponse.createByErrorMessage("数据库操作失败，请联系管理员");
    }

    @Override
    public ServerResponse login(Login login) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        List<Login> loginList = loginMapper.findAll(login);
        if(loginList != null && loginList.size() == 1){
            return ServerResponse.createBySuccess(loginList.get(0));
        }
        return ServerResponse.createByErrorMessage("用户名或密码错误");
    }

    @Override
    public Login getUserInfoByIdLike(String id) {
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
       Login login = loginMapper.selectByPrimaryKey(id);
        if(login != null){
            return login;
        }
        return null;
    }


    String idIsExist(String id, String businessType){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_PRD1);
        String name = "";
        if("1".equals(businessType) || "3".equals(businessType)){
            name = xsogroupMapper.selectStorerById(id);
        }else if("2".equals(businessType)){
            name = xsogroupMapper.selectJiaoCaiStorerById(id);
        }
        return name;
    }

    boolean isRegistered (String id, String businessType){
        DataSourceContextHolder. setDbType(DataSourceContextHolder.SESSION_FACTORY_XH);
        Login login = new Login();
        login.setId(id);
        login.setBk5(businessType);
        List<Login> loginList = loginMapper.findAll(new Login(id, businessType));
        if(loginList != null && loginList.size() > 0){
            return true;
        }
        return false;
    }


    @Override
    public void test() throws Exception {
        String imgPath = "http://img.jxlh56.com/01/3be84b36-ba3e-4d6b-89ef-b05a66438ee2.jpg";

        String mediaId = getMediaIdFromUrl(imgPath, "jpg");

// 上传图文消息的正文图片(返回的url拼在正文的<img>标签中)
        WxMpMassNews news = new WxMpMassNews();
        WxMpMassNews.WxMpMassNewsArticle article1 = new WxMpMassNews.WxMpMassNewsArticle();
        article1.setTitle("标题1");
        article1.setContent("内容1");
        article1.setThumbMediaId(mediaId);
        news.addArticle(article1);



        String imgPath2 = "http://img.jxlh56.com/01/7a9b4090-b720-45f2-80bc-7ebf82533dd2.jpg";
        String mediaId2 = getMediaIdFromUrl(imgPath2, "jpg");
        WxMpMassNews.WxMpMassNewsArticle article2 = new WxMpMassNews.WxMpMassNewsArticle();
        article2.setTitle("标题2");
        article2.setContent("内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2内容2");
        article2.setThumbMediaId(mediaId2);
        article2.setShowCoverPic(true);
        article2.setAuthor("作者2");
        //article2.setContentSourceUrl("www.baidu.com");
        article2.setDigest("摘要2");
        news.addArticle(article2);

        WxMpMassUploadResult massUploadResult = wxMpService.getMassMessageService().massNewsUpload(news);

        WxMpMassOpenIdsMessage massMessage = new WxMpMassOpenIdsMessage();
        massMessage.setMsgType(WxConsts.MassMsgType.MPNEWS);
        massMessage.setMediaId(massUploadResult.getMediaId());
        List<String> list = new ArrayList<>();
        //list.add("ogodE5zVenVrCCm04Cn79HgmbaQk");
        list.add("oPOAgvx1Utuu0Mg25QTPs5yqDUyw");
        list.add("oPOAgvx1Utuu0Mg25QTPs5yqDUyw");
        massMessage.setToUsers(list);
        //massMessage.getToUsers().add("ogodE5zVenVrCCm04Cn79HgmbaQk");
        //massMessage.getToUsers().add("ogodE5zVenVrCCm04Cn79HgmbaQk");

        try {
            WxMpMassSendResult massResult = wxMpService.getMassMessageService().massOpenIdsMessageSend(massMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }


    public String getMediaIdFromUrl(String urlPath, String fileType) throws Exception {

        InputStream is = getInputStreamByUrl(urlPath);

        WxMediaUploadResult res = wxMpService.getMaterialService().mediaUpload(WxConsts.MediaFileType.IMAGE, fileType, is);
        res.getType();
        res.getCreatedAt();
        res.getMediaId();
        res.getThumbMediaId();
        return res.getMediaId();
    }

    public static InputStream getInputStreamByUrl(String strUrl){
        HttpURLConnection conn = null;
        try {
            URL url = new URL(strUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(20 * 1000);
            final ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(conn.getInputStream(),output);
            return  new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            logger.error(e+"");
        }finally {
            try{
                if (conn != null) {
                    conn.disconnect();
                }
            }catch (Exception e){
                logger.error(e+"");
            }
        }
        return null;
    }

}
