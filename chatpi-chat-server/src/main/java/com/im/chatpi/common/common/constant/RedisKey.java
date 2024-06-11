package com.im.chatpi.common.common.constant;

/**
 * RedisKey
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/11 14:13
 * @description：
 */
public class RedisKey {
    
    private static final String BASE_KEY = "chatpi:";
    
    /**
     * 用户token存放
     */
    public static final String USER_TOKEN_STRING = "userToken:uid_%d";
    
    public static String getKey(String key, Object... objects) {
        return BASE_KEY + String.format(key, objects);
    }
}
