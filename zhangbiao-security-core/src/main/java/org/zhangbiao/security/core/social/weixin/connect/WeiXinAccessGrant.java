package org.zhangbiao.security.core.social.weixin.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * @author zhangbiao
 * @date 2019/11/19 14:29
 */
public class WeiXinAccessGrant extends AccessGrant {

    private String openId;

    public WeiXinAccessGrant() {
        super("");
    }

    public WeiXinAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
        super(accessToken, scope, refreshToken, expiresIn);
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
