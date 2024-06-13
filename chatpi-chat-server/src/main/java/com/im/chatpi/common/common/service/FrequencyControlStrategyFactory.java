package com.im.chatpi.common.common.service;

import com.im.chatpi.common.common.domain.dto.FrequencyControlDTO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 限流工厂
 *
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/12 17:18
 * @description：
 */
public class FrequencyControlStrategyFactory {
    
    /**
     * 指定时间内总次数限流
     */
    public static final String TOTAL_COUNT_WITH_IN_FIX_TIME_FREQUENCY_CONTROLLER = "TotalCountWithInFixTime";
    
    /**
     * 限流策略集合
     */
    static Map<String, AbstractFrequencyControlService<?>> frequencyControlServiceStrategyMap = new ConcurrentHashMap<>();
    
    @SuppressWarnings("unchecked")
    public static <K extends FrequencyControlDTO> AbstractFrequencyControlService<K> getFrequencyControllerByName(String key) {
        return (AbstractFrequencyControlService<K>) frequencyControlServiceStrategyMap.get(key);
    }
    
    public static <K extends FrequencyControlDTO> void registerFrequencyController(String key, AbstractFrequencyControlService<K> frequencyControlService) {
        frequencyControlServiceStrategyMap.put(key, frequencyControlService);
    }
    
    /**
     * 构造器私有(不希望外部实例化)
     */
    private FrequencyControlStrategyFactory() {
    
    }
}
