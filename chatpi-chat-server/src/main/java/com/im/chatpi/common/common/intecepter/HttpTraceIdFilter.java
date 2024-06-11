package com.im.chatpi.common.common.intecepter;

import com.im.chatpi.common.common.constant.MDCKey;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * 添加traceId，用于链路追踪
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/11 10:40
 * @description：
 */
@Slf4j
@WebFilter(urlPatterns = "/*")
public class HttpTraceIdFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String tid = UUID.randomUUID().toString();
        MDC.put(MDCKey.TID, tid);
        filterChain.doFilter(request, response);
        MDC.remove(MDCKey.TID);
    }
}
