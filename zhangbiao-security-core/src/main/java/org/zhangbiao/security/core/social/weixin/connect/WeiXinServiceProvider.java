package org.zhangbiao.security.core.social.weixin.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.zhangbiao.security.core.social.weixin.api.WeiXin;
import org.zhangbiao.security.core.social.weixin.api.WeiXinImpl;

/**
 * 微信的OAuth2流程处理器的提供其，供Spring Social的connect体系调用
 *
 * @author zhangbiao
 * @date 2019/11/19 14:36
 */
public class WeiXinServiceProvider extends AbstractOAuth2ServiceProvider<WeiXin> {

    /**
     * 微信获取授权码的URL
     */
    private static final String URL_AUTHORIZATION = "https://open.weixin.qq.com/connect/qrconnect";

    /**
     * 微信获取accessToken的URL
     */
    private static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    /**
     * @param oauth2Operations the OAuth2Operations template for conducting the OAuth 2 flow with the provider.
     */
    public WeiXinServiceProvider(String appId, String appSecret) {
        super(new WeiXinOAuth2Template(appId, appSecret, URL_AUTHORIZATION, URL_ACCESS_TOKEN));
    }


    @Override
    public WeiXin getApi(String accessToken) {
        return new WeiXinImpl(accessToken);
    }
}
