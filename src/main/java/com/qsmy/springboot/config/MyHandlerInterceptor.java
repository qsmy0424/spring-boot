package com.qsmy.springboot.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            // 未登陆，返回登录页面
            request.getRequestDispatcher("interceptor").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {

    }
}
