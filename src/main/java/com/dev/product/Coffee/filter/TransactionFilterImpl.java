package com.dev.product.Coffee.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Order(1)
public class TransactionFilterImpl implements TransactionFilter {
    
    private final static Logger log = LoggerFactory.getLogger(TransactionFilterImpl.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing filter: {}", this);
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Starting transaction for req: {}", req.getRequestURI());
        chain.doFilter(request, response);
        log.info("Committing transaction for req: {}", req.getRequestURI());
    }
    
    @Override
    public void destroy() {
        log.warn("Destructing filter: {}", this);
    }
}
