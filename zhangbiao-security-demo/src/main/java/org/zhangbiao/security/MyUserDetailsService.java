package org.zhangbiao.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 16:06
 */
@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("表单登录用户名：" + s);
        return buildUser(s);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String s) throws UsernameNotFoundException {
        logger.info("社交登录用户ID：" + s);
        return buildUser(s);
    }

    private SocialUserDetails buildUser(String s) {
        String password = passwordEncoder.encode("zhangbiao");
        logger.info("用户密码：" + password);
        SocialUser user = new SocialUser(s, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
