package org.zhangbiao.security.browser.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.zhangbiao.security.core.authentication.AuthenticationFailureHandleCustomize;
import org.zhangbiao.security.core.authentication.AuthenticationSuccessHandleCustomize;
import org.zhangbiao.security.core.config.SmsCodeAuthenticationSecurityConfiguration;
import org.zhangbiao.security.core.config.AbstractChannelSecurityConfiguration;
import org.zhangbiao.security.browser.service.MyUserDetailsService;
import org.zhangbiao.security.core.config.ValidateCodeSecurityConfiguration;
import org.zhangbiao.security.core.properties.SecurityConstants;
import org.zhangbiao.security.core.properties.SecurityProperties;

import javax.sql.DataSource;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 13:42
 */
@EnableConfigurationProperties(SecurityProperties.class)
@Configuration
public class BrowserSecurityConfiguration extends AbstractChannelSecurityConfiguration {

    @Autowired
    private ValidateCodeSecurityConfiguration validateCodeSecurityConfiguration;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfiguration smsCodeAuthenticationSecurityConfiguration;

    @Bean
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource());
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);
        http.apply(validateCodeSecurityConfiguration)
                .and()
                .apply(smsCodeAuthenticationSecurityConfiguration)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.DEAFULT_VALIDATE_CODE_URL_PREFIX + "/*",
                        securityProperties.getBrowser().getLoginPage())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
