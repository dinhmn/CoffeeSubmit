package com.dev.product.Coffee.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(2)
public class RequestResponseLoggingFilterImpl implements RequestResponseLoggingFilter {
    
    private final static Logger log = LoggerFactory.getLogger(RequestResponseLoggingFilterImpl.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing filter: {}", this);
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        log.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("Logging Response :{}", res.getContentType());
    }
    
    @Override
    public void destroy() {
        log.warn("Destructing filter :{}", this);
    }
}
