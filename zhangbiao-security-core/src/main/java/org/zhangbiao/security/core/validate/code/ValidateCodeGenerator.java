package org.zhangbiao.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 20:49
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(HttpServletRequest request);

}
