package com.management.aspect;

import com.management.common.Constant;
import com.management.common.RequestHolder;
import com.management.exception.MyException;
import com.management.pojo.login.Login;
import com.management.service.login.UserService;
import com.management.util.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 廖师兄
 * 2017-01-15 12:31
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    UserService userService;


//    @Pointcut("execution(public * com.management.controller.login.UserController.*(..))")
    @Pointcut("execution(public * com.management.controller..*.*(..)) " +
            "&& !execution(public * com.management.controller.wechat..*.*(..)) " +
            "&& !execution(public * com.management.controller.busi.BusiMessageWxController.queryInfo2(..)) " +
            "&& !execution(public * com.management.controller.info.InfoErrorController.likuError(..)) " +
            "&& !execution(public * com.management.controller.info.InfoErrorController.*(..)) " +
            "&& !execution(public * com.management.controller.jxlh56.NoticeController.*(..)) " +
            "&& !execution(public * com.management.controller.jxlh56.NewsController.*(..)) " +
            "&& !execution(public * com.management.controller.login.UserController.login(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute(Constant.CURRENT_USER);
        if(login == null ){
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
                if(login == null ){
                    throw  new MyException(10, "需登录");
                }
            }
            return;
        }
        logger.info("---------------成功获得登录信息："+ login.getId() +"---------------");
        RequestHolder.add(login);
        RequestHolder.add(request);

        logger.info("---------------这里是请求完成之前的操作---------------");
        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", IpUtil.getUserIP(request));

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("---------------这里是请求完成之后的操作---------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}",  object == null ? null :object.toString());
    }

}
