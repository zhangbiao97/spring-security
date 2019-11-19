package org.zhangbiao.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zhangbiao
 * @date 2019/11/18 16:46
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
