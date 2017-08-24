package com.mindflow.servlet3.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ricky Fung
 */
public class CharacterEncodingFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String encoding;
    private boolean forceRequestEncoding;
    private boolean forceResponseEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        String forceEncoding = filterConfig.getInitParameter("forceEncoding");
        logger.info("init encoding:{}, forceEncoding:{}", encoding, forceEncoding);
        if(forceEncoding!=null && forceEncoding.length()>0) {
            boolean flag = Boolean.valueOf(forceEncoding);
            this.forceRequestEncoding = flag;
            this.forceResponseEncoding = flag;
        } else {
            this.forceRequestEncoding = false;
            this.forceResponseEncoding = false;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter start");
        if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            String encoding = this.getEncoding();
            if(encoding != null) {
                if(this.isForceRequestEncoding() || request.getCharacterEncoding() == null) {
                    request.setCharacterEncoding(encoding);
                }
                if(this.isForceResponseEncoding()) {
                    response.setCharacterEncoding(encoding);
                }
            }
            filterChain.doFilter(request, response);
            logger.info("doFilter end");
        } else {
            throw new ServletException("CharacterEncodingFilter just supports HTTP requests");
        }
    }

    @Override
    public void destroy() {
        logger.info("destroy...");
    }

    public String getEncoding() {
        return encoding;
    }

    public boolean isForceRequestEncoding() {
        return forceRequestEncoding;
    }

    public boolean isForceResponseEncoding() {
        return forceResponseEncoding;
    }
}
