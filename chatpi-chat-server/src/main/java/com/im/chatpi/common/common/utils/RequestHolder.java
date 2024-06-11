package com.im.chatpi.common.common.utils;


import com.im.chatpi.common.common.domain.dto.RequestInfo;

/**
 * 请求上下文
 * @author: GuoZeTao
 * @Date: 2024/6/11 11:23
 * @params:
 * @return:
 **/
public class RequestHolder {

    private static final ThreadLocal<RequestInfo> threadLocal = new ThreadLocal<>();

    public static void set(RequestInfo requestInfo) {
        threadLocal.set(requestInfo);
    }

    public static RequestInfo get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
