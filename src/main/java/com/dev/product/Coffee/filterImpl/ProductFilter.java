package com.dev.product.Coffee.filterImpl;

import org.slf4j.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductFilter implements Filter {
    
    private final static Logger log = LoggerFactory.getLogger(ProductFilter.class);
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        log.info("Logging User Request  {} : {}", req.getMethod(), req.getRequestURI());
        chain.doFilter(request, response);
        log.info("Logging User Response :{}", res.getContentType());
    }
}
