package org.zhangbiao.security.core.social.qq.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.zhangbiao.security.core.social.qq.api.QQ;

/**
 * @author zhangbiao
 * @date 2019/11/18 16:05
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
