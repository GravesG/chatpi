package com.im.chatpi.common.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.chatpi.common.user.domain.entity.Black;
import com.im.chatpi.common.user.mapper.BlackMapper;
import org.springframework.stereotype.Service;

/**
 * 黑名单 服务实现类
 *
 * @author: GuoZeTao
 * @Date: 2024/6/7 17:48
 **/
@Service
public class BlackDao extends ServiceImpl<BlackMapper, Black> {

}
