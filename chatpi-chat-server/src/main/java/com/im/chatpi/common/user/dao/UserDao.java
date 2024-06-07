package com.im.chatpi.common.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.chatpi.common.user.domain.entity.User;
import com.im.chatpi.common.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author: GuoZeTao
 * @Date: 2024/6/7 17:47
 **/
@Service
public class UserDao extends ServiceImpl<UserMapper, User> {

    
}
