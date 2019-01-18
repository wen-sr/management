package com.management.aspect;

import com.management.util.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 廖师兄
 * 2017-01-15 12:31
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


//    @Pointcut("execution(public * com.management.controller.login.UserController.*(..))")
    @Pointcut("execution(public * com.management.controller..*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //HttpServletResponse response = attributes.getResponse();
        //HttpSession session = request.getSession();
        //Login login = (Login) session.getAttribute("login");
        //if(login == null ){
        //    response.sendRedirect("/login.html");
        //    return;
        //}
        //
        //RequestHolder.add(login);
        //RequestHolder.add(request);

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
        logger.info("这里是请求完成之后的操作---------------");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}",  object == null ? null :object.toString());
    }

}
