package org.zhangbiao.security.core.social.weixin.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.util.Map;

/**
 * 完成微信的OAuth2认证流程的模板类。国内厂商实现OAuth2每个都不同，Spring默认提供的OAuth2Template适应不了，只能针对每个厂商自己微调。
 *
 * @author zhangbiao
 * @date 2019/11/19 14:10
 */
public class WeiXinOAuth2Template extends OAuth2Template {

    private String clientId;

    private String clientSecret;

    private String accessTokenUrl;

    private static final String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

    private Logger logger = LoggerFactory.getLogger(getClass());

    public WeiXinOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
        setUseParametersForClientAuthentication(true);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessTokenUrl = accessTokenUrl;
    }

    @Override
    public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
        StringBuilder accessTokenRequestUrl = new StringBuilder(accessTokenUrl);
        accessTokenRequestUrl.append("?appid=" + clientId);
        accessTokenRequestUrl.append("&secret=" + clientSecret);
        accessTokenRequestUrl.append("&code=" + authorizationCode);
        accessTokenRequestUrl.append("&grant_type=authorization_code");
        accessTokenRequestUrl.append("&redirect_uri=" + redirectUri);
        return getAccessGrant(accessTokenRequestUrl);
    }

    public AccessGrant refreshAccess(String refreshToken, MultiValueMap<String, String> additionalParameters) {
        StringBuilder refreshTokenUrl = new StringBuilder(REFRESH_TOKEN_URL);
        refreshTokenUrl.append("?appid=" + clientId);
        refreshTokenUrl.append("&grant_type=refresh_token");
        refreshTokenUrl.append("&refresh_token=" + refreshToken);
        return getAccessGrant(refreshTokenUrl);
    }

    private AccessGrant getAccessGrant(StringBuilder accessTokenRequestUrl) {
        logger.info("获取access_token,请求URL：" + accessTokenRequestUrl.toString());
        String response = getRestTemplate().getForObject(accessTokenRequestUrl.toString(), String.class);
        logger.info("获取access_token,响应内容：" + response);
        Map<String, String> result = null;
        try {
            result = new ObjectMapper().readValue(response, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(MapUtils.getString(result, "errcode"))) {
            String errcode = MapUtils.getString(result, "errcode");
            String errmsg = MapUtils.getString(result, "errmsg");
            throw new RuntimeException("获取access_token失败,errcode：" + errcode + ",errmsg：" + errmsg);
        }

        WeiXinAccessGrant accessToken = new WeiXinAccessGrant(
                MapUtils.getString(result, "access_token"),
                MapUtils.getString(result, "scope"),
                MapUtils.getString(result, "refresh_token"),
                MapUtils.getLong(result, "expires_in")
        );
        accessToken.setOpenId(MapUtils.getString(result, "openid"));
        return accessToken;
    }


}
