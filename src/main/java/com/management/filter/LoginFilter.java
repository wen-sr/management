package com.management.filter;


import javax.servlet.*;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

    //public void init(FilterConfig filterConfig) throws ServletException {
    //
    //}
    //
    //public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    //    HttpServletRequest req = (HttpServletRequest) servletRequest;
    //    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    //
    //    Login sysUser = (Login)req.getSession().getAttribute("user");
    //    if (sysUser == null) {
    //        String path = "/login_old.html";
    //        resp.sendRedirect(path);
    //        return;
    //    }
    //    RequestHolder.add(sysUser);
    //    RequestHolder.add(req);
    //    filterChain.doFilter(servletRequest, servletResponse);
    //    return;
    //}
    //
    //public void destroy() {
    //
    //}
}
