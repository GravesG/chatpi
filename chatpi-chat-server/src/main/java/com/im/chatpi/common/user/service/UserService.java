package com.im.chatpi.common.user.service;

import com.im.chatpi.common.user.domain.vo.response.user.UserInfoResp;

public interface UserService {

    /**
     * 获取前端展示信息
     *
     * @param uid
     * @return
     */
    UserInfoResp getUserInfo(Long uid);


}
