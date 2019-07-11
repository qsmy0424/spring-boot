package com.qsmy.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author qsmy
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("filter filter -------------");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
