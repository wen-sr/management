package com.management.common;


import com.management.pojo.login.Login;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {

    private static final ThreadLocal<Login> userHolder = new ThreadLocal<Login>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(Login sysUser) {
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static Login getCurrentUser() {
        if(userHolder == null){
            return new Login("SYS", "SYS");
        }
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}
