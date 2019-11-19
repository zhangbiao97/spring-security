package org.zhangbiao.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhangbiao
 * @date 2019/11/19 15:11
 */
public class WeiXinProperties extends SocialProperties {

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是weixin
     */
    private String providerId = "weixin";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
