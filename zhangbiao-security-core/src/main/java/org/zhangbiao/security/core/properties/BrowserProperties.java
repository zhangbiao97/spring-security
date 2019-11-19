package org.zhangbiao.security.core.properties;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 20:16
 */
public class BrowserProperties {

    private SessionProperties session = new SessionProperties();

    private String loginPage = "/zhangbiao-signIn.html";

    private LoginResponseType loginType = LoginResponseType.JSON;

    private Integer rememberMeSeconds = 3600;


    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }

    public Integer getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(Integer rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }
}
