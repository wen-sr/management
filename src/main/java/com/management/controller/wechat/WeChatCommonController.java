package com.management.controller.wechat;

import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.common.ResponseCode;
import com.management.common.ServerResponse;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.login.UserService;
import com.management.service.wechat.IWeChatCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.SessionScope;

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
    public ServerResponse register(Login login, HttpSession session, HttpServletResponse res) {
        ServerResponse response = weChatCommonService.register(login);
        session.setAttribute(Constant.CURRENT_USER, response.getData());
        RequestHolder.add((Login) response.getData());
        Cookie cookie = new Cookie(Constant.USERID, login.getId());
        cookie.setMaxAge(24 * 3600 * 30);
        cookie.setPath("/");
        //把cookie给浏览器
        res.addCookie(cookie);
        return response;
    }

    @RequestMapping("/login")
    @ResponseBody
    public ServerResponse login(Login login, HttpSession session, HttpServletResponse res) {
        ServerResponse response = weChatCommonService.login(login);
        if (response.isSuccess()) {
            login = (Login) response.getData();
            session.setAttribute(Constant.CURRENT_USER, response.getData());
            //cookie
            //Cookie cookie = new Cookie("user_name", URLEncoder.encode(user.getName() + "", "utf-8"));
            Cookie cookie = new Cookie(Constant.USERID, login.getId());
            cookie.setMaxAge(24 * 3600 * 30);
            cookie.setPath("/");
            //把cookie给浏览器
            res.addCookie(cookie);
        }

        return response;
    }

    @RequestMapping("/customerQuery")
    @ResponseBody
    public String customerQuery(HttpSession session, HttpServletRequest request) {
        Login user = (Login) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                for (Cookie cookie : cookies) {
                    if (Constant.USERID.equals(cookie.getName()) && cookie.getValue() != "") {
                        user = weChatCommonService.getUserInfoByIdLike(cookie.getValue());
                        user.setPwd("");
                        session.setAttribute(Constant.CURRENT_USER, user);
                        break;
                    }
                }
                if (user == null) {
                    return "/page/wechat/login.html";
                }
            } else {
                return "/page/wechat/customerQuery.html";
            }
        }
        return "/page/wechat/customerQuery.html";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public ServerResponse checkLogin(HttpServletRequest request, HttpSession session) {
            Login login = (Login) session.getAttribute(Constant.CURRENT_USER);
            if (login == null) {
                Cookie[] cookies = request.getCookies();
                if (null != cookies) {
                    for (Cookie cookie : cookies) {
                        if (Constant.USERID.equals(cookie.getName()) && cookie.getValue() != "") {
                            login = userService.getUserInfoById(cookie.getValue());
                            login.setPwd("");
                            session.setAttribute(Constant.CURRENT_USER, login);
                            RequestHolder.add(login);
                            break;
                        }
                    }
                }
            }
        if (login == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NOTHING.getCode(), "未登录");
        }
        login.setPwd("");
        return ServerResponse.createBySuccess(login);
    }

    @RequestMapping("/needLogin")
    @ResponseBody
    public ServerResponse needLogin(HttpServletRequest request, HttpSession session) {
            Login login = (Login) session.getAttribute(Constant.CURRENT_USER);
            if (login == null) {
                Cookie[] cookies = request.getCookies();
                if (null != cookies) {
                    for (Cookie cookie : cookies) {
                        if (Constant.USERID.equals(cookie.getName()) && cookie.getValue() != "") {
                            login = userService.getUserInfoById(cookie.getValue());
                            login.setPwd("");
                            session.setAttribute(Constant.CURRENT_USER, login);
                            RequestHolder.add(login);
                            break;
                        }
                    }
                }
            }
        if (login == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录");
        }
        return null;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ServerResponse logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Login user = (Login) session.getAttribute(Constant.CURRENT_USER);
        if(user == null){
            user = RequestHolder.getCurrentUser();
            if(user == null) {
                throw new MyException(-1, "未登录");
            }
        }
        session.removeAttribute(Constant.CURRENT_USER);
        RequestHolder.remove();
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(Constant.USERID)) {
//                        cookies[i].setValue("");
                    Cookie cookie = new Cookie(Constant.USERID, "");//这边得用"",不能用null
                    cookie.setPath("/");//设置成跟写入cookies一样的
//                        // cookie.setDomain(".wangwz.com");//设置成跟写入cookies一样的
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/modifyPassword")
    @ResponseBody
    public ServerResponse modifyPassword(String id, String password_old, String password) {
        return userService.modifyPwd(id, password_old, password);
    }
}
