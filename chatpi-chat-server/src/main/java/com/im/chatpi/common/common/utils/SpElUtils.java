package com.im.chatpi.common.common.utils;

import java.lang.reflect.Method;

/**
 * spring el表达式解析
 *
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/12 17:05
 * @description：
 */
public class SpElUtils {
    public static String getMethodKey(Method method) {
        return method.getDeclaringClass() + "#" + method.getName();
    }
}
