package com.im.chatpi.common.common.utils;

import com.im.chatpi.common.common.exception.BusinessErrorEnum;
import com.im.chatpi.common.common.exception.BusinessException;
import com.im.chatpi.common.common.exception.ErrorEnum;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * @author ：GuoZeTao
 * @date ：Created in 2024/6/13 11:07
 * @description：
 */
public class AssertUtil {
    
    //如果是true，则抛异常
    public static void isFalse(boolean expression, String msg) {
        if (expression) {
            throwException(msg);
        }
    }
    
    private static void throwException(String msg) {
        throwException(null, msg);
    }
    
    private static void throwException(ErrorEnum errorEnum, Object... arg) {
        if (Objects.isNull(errorEnum)) {
            errorEnum = BusinessErrorEnum.BUSINESS_ERROR;
        }
        throw new BusinessException(errorEnum.getErrorCode(), MessageFormat.format(errorEnum.getErrorMsg(), arg));
    }
}
