package org.zhangbiao.security.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.zhangbiao.security.core.authentication.AuthenticationFailureHandleCustomize;
import org.zhangbiao.security.core.authentication.AuthenticationSuccessHandleCustomize;
import org.zhangbiao.security.core.authentication.code.SmsCodeAuthenticationFilter;
import org.zhangbiao.security.core.authentication.code.SmsCodeAuthenticationProvider;

/**
 * @author zhangbiao
 * @date 2019/11/16 23:37
 */
@Component
public class SmsCodeAuthenticationSecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandleCustomize authenticationSuccessHandleCustomize;

    @Autowired
    private AuthenticationFailureHandleCustomize authenticationFailureHandleCustomize;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandleCustomize);
        smsCodeAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandleCustomize);

        SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(smsCodeAuthenticationProvider)
                .addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
