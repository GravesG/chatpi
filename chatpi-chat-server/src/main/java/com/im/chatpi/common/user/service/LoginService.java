package com.im.chatpi.common.user.service;

/**
 * 登录相关处理类
 * @author: GuoZeTao
 * @Date: 2024/6/11 15:00
 * @params:
 * @return:
 **/
public interface LoginService {


    /**
     * 校验token是不是有效
     *
     * @param token
     * @return
     */
    boolean verify(String token);

    /**
     * 刷新token有效期
     *
     * @param token
     */
    void renewalTokenIfNecessary(String token);

    /**
     * 登录成功，获取token
     *
     * @param uid
     * @return 返回token
     */
    String login(Long uid);

    /**
     * 如果token有效，返回uid
     *
     * @param token
     * @return
     */
    Long getValidUid(String token);

}
