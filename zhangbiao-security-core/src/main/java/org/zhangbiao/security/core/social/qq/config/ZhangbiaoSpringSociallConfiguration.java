package org.zhangbiao.security.core.social.qq.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author zhangbiao
 * @date 2019/11/18 19:48
 */
public class ZhangbiaoSpringSociallConfiguration extends SpringSocialConfigurer {

    private String filterProcessorUrl;


    public ZhangbiaoSpringSociallConfiguration(String filterProccessorUrl) {
        this.filterProcessorUrl = filterProccessorUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter socialAuthenticationFilter = (SocialAuthenticationFilter) super.postProcess(object);
        socialAuthenticationFilter.setFilterProcessesUrl(filterProcessorUrl);
        return (T) socialAuthenticationFilter;
    }

}
