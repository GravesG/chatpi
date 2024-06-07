package com.im.chatpi.common.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.chatpi.common.user.domain.entity.Role;
import com.im.chatpi.common.user.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * 角色表 服务实现类
 *
 * @author: GuoZeTao
 * @Date: 2024/6/7 17:48
 **/
@Service
public class RoleDao extends ServiceImpl<RoleMapper, Role> {

}
