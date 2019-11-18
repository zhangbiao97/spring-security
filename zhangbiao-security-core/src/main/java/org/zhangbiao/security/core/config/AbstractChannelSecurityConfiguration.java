package org.zhangbiao.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.zhangbiao.security.core.authentication.AuthenticationSuccessHandleCustomize;
import org.zhangbiao.security.core.properties.SecurityConstants;

/**
 * @author zhangbiao
 * @date 2019/11/17 1:12
 */
public class AbstractChannelSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessCustomize;

    @Autowired
    protected AuthenticationFailureHandler authenticationFailureCustomize;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessCustomize)
                .failureHandler(authenticationFailureCustomize);
    }

}
