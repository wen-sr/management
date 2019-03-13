package com.management.controller.wechat;

import com.management.common.Constant;
import com.management.common.ServerResponse;
import com.management.pojo.login.Login;
import com.management.pojo.wechat.UserInfo;
import com.management.service.login.UserService;
import com.management.service.wechat.IUserInfoService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/oa/wechat")
public class OAController {

    @Autowired
    WxMpService wxMpService;

    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    UserService userService;

    @RequestMapping("/auth")
    public String auth(String returnUrl) throws UnsupportedEncodingException {
        String url = Constant.WECHATDOMAIN + "/management/oa/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl,"utf-8"));
//        System.out.println(redirectUrl);
        return "redirect:" + redirectUrl;
    }

    @RequestMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl,
                           HttpSession session) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = (WxMpOAuth2AccessToken) session.getAttribute(Constant.WXMPOAUTH2ACCESSTOKEN);
//        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            if(wxMpOAuth2AccessToken == null || wxMpOAuth2AccessToken.getOpenId() == null ){
                wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                session.setAttribute(Constant.WXMPOAUTH2ACCESSTOKEN, wxMpOAuth2AccessToken);
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        //将openid放入到session中
        //根据openid找到对应的工号
        String openId = wxMpOAuth2AccessToken.getOpenId();
        UserInfo userInfo = userInfoService.findByOpenId(openId);
        //if(userInfo == null || userInfo.getLoginId() == null) {
        //    return "redirect:/page/error/wechatNoAccess.html";
        //}
        Login user = userService.getUserInfoById(userInfo.getLoginId());
        session.setAttribute(Constant.CURRENT_USER, user);
        return "redirect:" + returnUrl;
    }


    @RequestMapping("/deviceNeedRepair")
    public ServerResponse addRepair(){
        System.out.println("*******************************************");
        return null;
    }


}
