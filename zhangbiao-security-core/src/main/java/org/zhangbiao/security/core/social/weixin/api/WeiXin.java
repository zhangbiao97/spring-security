package org.zhangbiao.security.core.social.weixin.api;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/19 13:48
 */
public interface WeiXin {

    WeiXinUserInfo getUserInfo(String openId);

}
