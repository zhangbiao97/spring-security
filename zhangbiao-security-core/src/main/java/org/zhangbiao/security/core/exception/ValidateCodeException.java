package org.zhangbiao.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 17:20
 */
public class ValidateCodeException extends AuthenticationException {


    public ValidateCodeException(String message) {
        super(message);
    }
}
