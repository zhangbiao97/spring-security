package org.zhangbiao.security.core.properties;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 19:44
 */
public class SmsCodeProperties {
    private Integer length = 6;
    private Integer expireIn = 120;
    private String url = "";

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }
}
