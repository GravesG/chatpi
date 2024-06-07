package com.im.chatpi.common.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.im.chatpi.common.user.dao.UserDao;
import com.im.chatpi.common.user.domain.entity.User;
import com.im.chatpi.common.user.domain.vo.response.user.UserInfoResp;
import com.im.chatpi.common.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfoResp getUserInfo(Long uid) {
        User user = userDao.getById(uid);
        UserInfoResp userInfoResp = new UserInfoResp();
        BeanUtil.copyProperties(user, userInfoResp);
        return userInfoResp;
    }

}
