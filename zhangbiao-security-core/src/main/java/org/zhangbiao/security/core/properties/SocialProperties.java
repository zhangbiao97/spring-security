package org.zhangbiao.security.core.properties;

/**
 * @author zhangbiao
 * @date 2019/11/18 16:47
 */
public class SocialProperties {

    private String filterProcessorUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeiXinProperties weixin = new WeiXinProperties();

    public WeiXinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeiXinProperties weixin) {
        this.weixin = weixin;
    }

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessorUrl() {
        return filterProcessorUrl;
    }

    public void setFilterProcessorUrl(String filterProcessorUrl) {
        this.filterProcessorUrl = filterProcessorUrl;
    }
}
