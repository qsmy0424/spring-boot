package com.qsmy.springboot.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author qsmy
 * @date 2019-07-24
 */
@Slf4j
@WebFilter(filterName = "AnnotationFilter", urlPatterns = "/annServlet")
public class AnnotationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("进入filter：AnnotationFilter");
        chain.doFilter(request, response);
        log.info("离开filter：AnnotationFilter");
    }

    @Override
    public void destroy() {

    }
}
