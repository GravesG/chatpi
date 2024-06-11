package com.im.chatpi.common.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 黑名单类型
 * @author: GuoZeTao
 * @Date: 2024/6/11 11:26
 * @params:
 * @return:
 **/
@AllArgsConstructor
@Getter
public enum BlackTypeEnum {
    /**
     *黑名单属性
     **/
    IP(1),
    UID(2),
    ;

    private final Integer type;

}
