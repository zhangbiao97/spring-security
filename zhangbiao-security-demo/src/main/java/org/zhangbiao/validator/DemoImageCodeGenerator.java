package org.zhangbiao.validator;

import org.springframework.stereotype.Component;
import org.zhangbiao.security.core.validate.code.ImageCode;
import org.zhangbiao.security.core.validate.code.ValidateCodeGenerator;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 21:01
 */
@Component("ceshiCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(HttpServletRequest request) {
        System.out.println("更高级的图片验证码");
        return null;
    }

}
