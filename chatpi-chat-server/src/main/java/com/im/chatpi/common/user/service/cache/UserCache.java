package com.im.chatpi.common.user.service.cache;

import com.im.chatpi.common.user.dao.BlackDao;
import com.im.chatpi.common.user.domain.entity.Black;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户缓存相关
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/11 11:20
 * @description：
 */
@Component
public class UserCache {
    @Autowired
    private BlackDao blackDao;
    
    @Cacheable(cacheNames = "user", key = "'blackList'")
    public Map<Integer, Set<String>> getBlackMap() {
        Map<Integer, List<Black>> collect = blackDao.list().stream().collect(Collectors.groupingBy(Black::getType));
        Map<Integer, Set<String>> result = new HashMap<>(collect.size());
        for (Map.Entry<Integer, List<Black>> entry : collect.entrySet()) {
            result.put(entry.getKey(), entry.getValue().stream().map(Black::getTarget).collect(Collectors.toSet()));
        }
        return result;
    }
}
