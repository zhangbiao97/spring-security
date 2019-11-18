package org.zhangbiao.security.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zhangbiao.security.core.validate.code.ImageCodeGenerator;
import org.zhangbiao.security.core.validate.code.SmsCodeGenerator;
import org.zhangbiao.security.core.validate.code.ValidateCodeGenerator;
import org.zhangbiao.security.core.validate.code.sms.DefaultSmsCodeSender;
import org.zhangbiao.security.core.validate.code.sms.SmsCodeSender;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 20:55
 */
@Configuration
public class ValidateCodeBeanConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        return imageCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }


}
