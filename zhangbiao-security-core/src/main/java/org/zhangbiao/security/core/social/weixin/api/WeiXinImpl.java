package org.zhangbiao.security.core.social.weixin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;
import sun.awt.CharsetString;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.List;

/**
 * @author zhangbiao
 * @date 2019/11/19 13:56
 */
public class WeiXinImpl extends AbstractOAuth2ApiBinding implements WeiXin {

    /**
     * 获取用户信息的URL
     */
    private static final String URL_GET_USER_INFO = "https://api.weixin.qq.com/sns/userinfo?openid=";

    private ObjectMapper objectMapper = new ObjectMapper();

    public WeiXinImpl(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    }

    /**
     * 默认注册的StringHttpMessageConverter字符集为ISO-8859-1,而微信返回的是UTF-8，所以覆盖了原来的方法
     *
     * @return
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }

    /**
     * 获取微信用户信息
     *
     * @param openId
     * @return
     */
    @Override
    public WeiXinUserInfo getUserInfo(String openId) {
        String url = URL_GET_USER_INFO + openId;
        String result = getRestTemplate().getForObject(url, String.class);
        if (StringUtils.contains(result, "errcode")) {
            return null;
        }
        WeiXinUserInfo weiXinUserInfo = null;
        try {
            weiXinUserInfo = objectMapper.readValue(result, WeiXinUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weiXinUserInfo;
    }
}
