package com.im.chatpi.common.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.chatpi.common.user.domain.entity.UserRole;
import com.im.chatpi.common.user.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * 用户角色关系表 服务实现类
 *
 * @author: GuoZeTao
 * @Date: 2024/6/7 17:45
 **/
@Service
public class UserRoleDao extends ServiceImpl<UserRoleMapper, UserRole> {
}
