package org.zhangbiao.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.security.SpringSocialConfigurer;
import org.zhangbiao.security.core.properties.QQProperties;
import org.zhangbiao.security.core.properties.SecurityProperties;
import org.zhangbiao.security.core.social.qq.connect.QQConnectionFactory;

/**
 * @author zhangbiao
 * @date 2019/11/18 17:01
 */
@Configuration
@ConditionalOnProperty(prefix = "zhangbiao.security.social.qq",name = "app-id")
public class QQAutoConfiguration extends SocialAutoConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public SpringSocialConfigurer zhangbiaoSocialSecurityConfig(){
        String filterProcessorUrl = securityProperties.getSocial().getFilterProcessorUrl();
        ZhangbiaoSpringSociallConfiguration zhangbiaoSpringSociallConfiguration = new ZhangbiaoSpringSociallConfiguration(filterProcessorUrl);
        return zhangbiaoSpringSociallConfiguration;
    }

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qq = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qq.getProviderId(),qq.getAppId(),qq.getAppSecret());
    }
}
