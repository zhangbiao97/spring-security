package org.zhangbiao.security.browser.session;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author zhangbiao
 * @date 2019/11/19 22:05
 */
public class ZhangbiaoExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

    public ZhangbiaoExpiredSessionStrategy(String invalidSesionUrl) {
        super(invalidSesionUrl);
    }

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent eventØ) throws IOException, ServletException {
        eventØ.getResponse().setContentType("application/json;charset=UTF-8");
        eventØ.getResponse().getWriter().write("并发登录");
    }

    @Override
    protected boolean isConcurrency() {
        return true;
    }
}
