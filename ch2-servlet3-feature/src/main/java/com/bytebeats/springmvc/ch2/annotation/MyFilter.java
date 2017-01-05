package com.bytebeats.springmvc.ch2.annotation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-01-05 23:47
 */
@WebFilter(urlPatterns={"/*"}, filterName="myFilter",  asyncSupported=true)
@WebInitParam(name="path", value="ricky")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Servlet3 filter init");

        System.out.println("path:"+filterConfig.getInitParameter("path"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Servlet3 filter doFilter");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet3 filter destroy");
    }
}
