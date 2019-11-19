package org.zhangbiao.security.core.properties;

/**
 * @author zhangbiao
 * @date 2019/11/19 22:39
 */
public class SessionProperties {

    /**
     * 同一个用户在系统中的最大session数，默认为1
     */
    private Integer maximumSessions = 1;

    /**
     * 达到最大session时是否阻止新的登录请求，默认为false
     */
    private Boolean maxSessionPreventsLogin = false;

    private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;

    public Integer getMaximumSessions() {
        return maximumSessions;
    }

    public void setMaximumSessions(Integer maximumSessions) {
        this.maximumSessions = maximumSessions;
    }

    public Boolean getMaxSessionPreventsLogin() {
        return maxSessionPreventsLogin;
    }

    public void setMaxSessionPreventsLogin(Boolean maxSessionPreventsLogin) {
        this.maxSessionPreventsLogin = maxSessionPreventsLogin;
    }

    public String getSessionInvalidUrl() {
        return sessionInvalidUrl;
    }

    public void setSessionInvalidUrl(String sessionInvalidUrl) {
        this.sessionInvalidUrl = sessionInvalidUrl;
    }
}
