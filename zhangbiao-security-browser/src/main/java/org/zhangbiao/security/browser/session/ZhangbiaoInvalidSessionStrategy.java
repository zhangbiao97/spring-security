package org.zhangbiao.security.browser.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangbiao
 * @date 2019/11/19 22:31
 */
public class ZhangbiaoInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

    public ZhangbiaoInvalidSessionStrategy(String invalidSesionUrl) {
        super(invalidSesionUrl);
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        onSessionInvalid(request, response);
    }


}
