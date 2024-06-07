package com.im.chatpi.common.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.im.chatpi.common.user.domain.entity.ItemConfig;
import com.im.chatpi.common.user.mapper.ItemConfigMapper;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 功能物品配置表 服务实现类
 *
 * @author: GuoZeTao
 * @Date: 2024/6/7 17:48
 **/
@Service
public class ItemConfigDao extends ServiceImpl<ItemConfigMapper, ItemConfig> {
    
    public List<ItemConfig> getByType(Integer type) {
        return lambdaQuery().eq(ItemConfig::getType, type).list();
    }
}
