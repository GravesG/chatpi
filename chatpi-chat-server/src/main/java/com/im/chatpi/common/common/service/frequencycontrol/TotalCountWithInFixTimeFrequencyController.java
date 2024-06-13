package com.im.chatpi.common.common.service.frequencycontrol;

import com.im.chatpi.common.common.domain.dto.FrequencyControlDTO;
import com.im.chatpi.common.common.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.im.chatpi.common.common.service.frequencycontrol.FrequencyControlStrategyFactory.TOTAL_COUNT_WITH_IN_FIX_TIME_FREQUENCY_CONTROLLER;

/**
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/13 11:45
 * @description：
 */
@Slf4j
@Service
public class TotalCountWithInFixTimeFrequencyController extends AbstractFrequencyControlService<FrequencyControlDTO> {
    
    @Override
    protected void addFrequencyControlStatisticsCount(Map<String, FrequencyControlDTO> frequencyControlDtoMap) {
        frequencyControlDtoMap.forEach((k, v) -> RedisUtils.inc(k, v.getTime(), v.getUnit()));
    }
    
    @Override
    protected boolean reachRateLimit(Map<String, FrequencyControlDTO> frequencyControlDtoMap) {
        List<String> frequencyKeys = new ArrayList<>(frequencyControlDtoMap.keySet());
        List<Integer> countList = RedisUtils.mget(frequencyKeys, Integer.class);
        for (int i = 0; i < frequencyKeys.size(); i++) {
            String key = frequencyKeys.get(i);
            Integer count = countList.get(i);
            int frequencyControlCount = frequencyControlDtoMap.get(key).getCount();
            if (Objects.nonNull(count) && count >= frequencyControlCount) {
                //频率超过了
                log.warn("frequencyControl limit key:{},count:{}", key, count);
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected String getStrategyName() {
        return TOTAL_COUNT_WITH_IN_FIX_TIME_FREQUENCY_CONTROLLER;
    }
}
