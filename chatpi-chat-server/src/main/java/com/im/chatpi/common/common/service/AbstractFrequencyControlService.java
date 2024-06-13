package com.im.chatpi.common.common.service;

import com.im.chatpi.common.common.domain.dto.FrequencyControlDTO;
import com.im.chatpi.common.common.exception.CommonErrorEnum;
import com.im.chatpi.common.common.exception.FrequencyControlException;
import com.im.chatpi.common.common.utils.AssertUtil;
import org.apache.commons.lang3.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 抽象类频控服务 其他类如果要实现限流服务 直接注入使用通用限流类
 *
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/12 17:16
 * @description：
 */
public abstract class AbstractFrequencyControlService<K extends FrequencyControlDTO> {
    
    @PostConstruct
    protected void registerMyselfToFactory() {
        FrequencyControlStrategyFactory.registerFrequencyController(getStrategyName(), this);
    }
    
    public <T> T executeWithFrequencyControlList(List<K> frequencyControlList, SupplierThrowWithoutParam<T> supplier) throws Throwable {
        boolean existNullKey = frequencyControlList.stream().anyMatch(frequencyControlDTO -> ObjectUtils.isEmpty(frequencyControlDTO.getKey()));
        AssertUtil.isFalse(existNullKey, "限流策略的Key字段不允许出现空值");
        Map<String, K> frequencyControlDtoMap = frequencyControlList.stream().collect(Collectors.groupingBy(K::getKey, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0))));
        return executeWithFrequencyControlMap(frequencyControlDtoMap, supplier);
    }
    
    public <T> T executeWithFrequencyControlMap(Map<String, K> frequencyControlDtoMap, SupplierThrowWithoutParam<T> supplier) throws Throwable {
        if (reachRateLimit(frequencyControlDtoMap)) {
            throw new FrequencyControlException(CommonErrorEnum.FREQUENCY_LIMIT);
        }
        try {
            return supplier.get();
        } finally {
            //不管成功还是失败，都增加次数
            addFrequencyControlStatisticsCount(frequencyControlDtoMap);
        }
    }
    
    public <T> T executeWithFrequencyControl(K frequencyControl, SupplierThrowWithoutParam<T> supplier) throws Throwable {
        return executeWithFrequencyControlList(Collections.singletonList(frequencyControl), supplier);
    }
    
    /**
     * 增加限流统计次数 子类实现 每个子类都可以自定义自己的限流统计信息增加的逻辑
     *
     * @param frequencyControlDtoMap 定义的注解频控 Map中的Key-对应redis的单个频控的Key Map中的Value-对应redis的单个频控的Key限制的Value
     */
    protected abstract void addFrequencyControlStatisticsCount(Map<String, K> frequencyControlDtoMap);
    
    /**
     * 是否达到限流阈值 子类实现 每个子类都可以自定义自己的限流逻辑判断
     *
     * @param frequencyControlDtoMap 定义的注解频控 Map中的Key-对应redis的单个频控的Key Map中的Value-对应redis的单个频控的Key限制的Value
     * @return true-方法被限流 false-方法没有被限流
     */
    protected abstract boolean reachRateLimit(Map<String, K> frequencyControlDtoMap);
    
    
    @FunctionalInterface
    public interface SupplierThrowWithoutParam<T> {
        /**
         *
         **/
        T get() throws Throwable;
    }
    
    @FunctionalInterface
    public interface Executor<T> {
        /**
         *
         **/
        void execute() throws Throwable;
    }
    
    /**
     * 获取策略名称(子类实现)
     *
     * @return 策略名称
     */
    protected abstract String getStrategyName();
}
