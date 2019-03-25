package com.management.controller.wechat;

import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.common.ResponseCode;
import com.management.common.ServerResponse;
import com.management.pojo.login.Login;
import com.management.service.login.UserService;
import com.management.service.wechat.IWeChatCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/wechat/common")
public class WeChatCommonController {

    @Autowired
    IWeChatCommonService weChatCommonService;

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public ServerResponse register(Login login, HttpSession session, HttpServletResponse res){
        ServerResponse response = weChatCommonService.register(login);
        session.setAttribute(Constant.CURRENT_USER, response.getData());
        RequestHolder.add((Login) response.getData());
        Cookie cookie = new Cookie(Constant.USERID, login.getId());
        cookie.setMaxAge(3600*3);
        cookie.setPath("/");
        //把cookie给浏览器
        res.addCookie(cookie);
        return response;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServerResponse login(Login login, HttpSession session, HttpServletResponse res){
        ServerResponse response = weChatCommonService.login(login);

        if(response.isSuccess()){
            login = (Login) response.getData();
            session.setAttribute(Constant.CURRENT_USER, response.getData());
            //cookie
            //Cookie cookie = new Cookie("user_name", URLEncoder.encode(user.getName() + "", "utf-8"));
            Cookie cookie = new Cookie(Constant.USERID, login.getId());
            cookie.setMaxAge(3600*3);
            cookie.setPath("/");
            //把cookie给浏览器
            res.addCookie(cookie);
        }

        return response;
    }

    @RequestMapping("/customerQuery")
    @ResponseBody
    public String customerQuery(HttpSession session, HttpServletRequest request){
        Login user = (Login)session.getAttribute(Constant.CURRENT_USER);
        if(user == null ){
            Cookie[] cookies = request.getCookies();
            if(null!=cookies) {
                for (Cookie cookie : cookies) {
                    if(Constant.USERID.equals(cookie.getName()) && cookie.getValue() != ""){
                        user = weChatCommonService.getUserInfoByIdLike(cookie.getValue());
                        user.setPwd("");
                        session.setAttribute(Constant.CURRENT_USER, user);
                        break;
                    }
                }
                if(user == null ){
                    return "/page/wechat/login_old.html";
                }
            }else{
                return "/page/wechat/customerQuery.html";
            }
        }
        return "/page/wechat/customerQuery.html";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public ServerResponse checkLogin(HttpServletRequest request, HttpSession session){
        Login login = RequestHolder.getCurrentUser();
        if(login == null) {
            Cookie[] cookies = request.getCookies();
            if(null!=cookies) {
                for (Cookie cookie : cookies) {
                    if(Constant.USERID.equals(cookie.getName()) && cookie.getValue() != ""){
                        login = userService.getUserInfoById(cookie.getValue());
                        login.setPwd("");
                        session.setAttribute(Constant.CURRENT_USER, login);
                        RequestHolder.add(login);
                        break;
                    }
                }
            }
        }
        if(login == null ){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ERROR.getCode(), "未登录");
        }
        login.setPwd("");
        return ServerResponse.createBySuccess(login);
    }

    @RequestMapping("/needLogin")
    @ResponseBody
    public ServerResponse needLogin(HttpServletRequest request, HttpSession session){
        Login login = RequestHolder.getCurrentUser();
        if(login == null) {
            Cookie[] cookies = request.getCookies();
            if(null!=cookies) {
                for (Cookie cookie : cookies) {
                    if(Constant.USERID.equals(cookie.getName()) && cookie.getValue() != ""){
                        login = userService.getUserInfoById(cookie.getValue());
                        login.setPwd("");
                        session.setAttribute(Constant.CURRENT_USER, login);
                        RequestHolder.add(login);
                        break;
                    }
                }
            }
        }
        if(login == null ){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录");
        }
        return null;
    }
}
