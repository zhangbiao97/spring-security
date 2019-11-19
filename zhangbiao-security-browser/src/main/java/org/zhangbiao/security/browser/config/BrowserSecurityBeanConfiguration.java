package org.zhangbiao.security.browser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.zhangbiao.security.browser.session.ZhangbiaoExpiredSessionStrategy;
import org.zhangbiao.security.browser.session.ZhangbiaoInvalidSessionStrategy;
import org.zhangbiao.security.core.properties.SecurityProperties;

/**
 * @author zhangbiao
 * @date 2019/11/19 22:46
 */
@Configuration
public class BrowserSecurityBeanConfiguration {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new ZhangbiaoInvalidSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new ZhangbiaoExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
    }

}
