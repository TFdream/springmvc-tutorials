package com.mindflow.servlet3.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author Ricky Fung
 */
@WebFilter(urlPatterns = "/*", asyncSupported = true, initParams = {@WebInitParam(name = "encoding", value = "utf-8")})
public class DemoFilter  implements Filter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("doFilter start");
        chain.doFilter(request, response);
        logger.info("doFilter start");
    }

    @Override
    public void destroy() {
        logger.info("destroy");
    }
}
