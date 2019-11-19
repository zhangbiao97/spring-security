package org.zhangbiao.security.core.social.weixin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.zhangbiao.security.core.properties.SecurityProperties;
import org.zhangbiao.security.core.properties.WeiXinProperties;
import org.zhangbiao.security.core.social.weixin.connect.WeiXinConnectionFactory;

/**
 * @author zhangbiao
 * @date 2019/11/19 14:58
 */
@Configuration
@ConditionalOnProperty(prefix = "zhangbiao.security.social.weixin", name = "app-id")
public class WeiXinAutoConfiguration extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeiXinProperties weixin = securityProperties.getSocial().getWeixin();
        WeiXinConnectionFactory weiXinConnectionFactory = new WeiXinConnectionFactory(weixin.getProviderId(), weixin.getAppId(), weixin.getAppSecret());
        return weiXinConnectionFactory;
    }
}
