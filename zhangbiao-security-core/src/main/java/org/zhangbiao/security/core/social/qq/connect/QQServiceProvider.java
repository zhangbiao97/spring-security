package org.zhangbiao.security.core.social.qq.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;
import org.zhangbiao.security.core.social.qq.api.QQ;
import org.zhangbiao.security.core.social.qq.api.QQImpl;

/**
 * @author zhangbiao
 * @date 2019/11/18 15:47
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> implements OAuth2ServiceProvider<QQ> {

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    private String appId;

    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }

    @Override
    public QQImpl getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
