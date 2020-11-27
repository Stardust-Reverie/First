package edu.gd.test;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String date = new Date().toString();
        String adds = servletRequest.getRemoteAddr();
        System.out.println(date + " id:" + adds);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
