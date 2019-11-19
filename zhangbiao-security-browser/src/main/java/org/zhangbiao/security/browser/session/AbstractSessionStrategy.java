package org.zhangbiao.security.browser.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangbiao
 * @date 2019/11/19 22:17
 */
public class AbstractSessionStrategy {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 跳转的URL
     */
    private String destinationUrl;

    /**
     * 重定向策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 跳转前是否创建新的session
     */
    private boolean createNewSession = true;

    private ObjectMapper objectMapper = new ObjectMapper();

    public AbstractSessionStrategy(String invalidSesionUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSesionUrl));
        this.destinationUrl = invalidSesionUrl;
    }

    protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("session失效");
        if (createNewSession) {
            request.getSession();
        }
        String sourceUrl = request.getRequestURI();
        String targetUrl;
        if (StringUtils.endsWithIgnoreCase(sourceUrl, ".html")) {
            targetUrl = destinationUrl;
            logger.info("跳转到：" + targetUrl);
            redirectStrategy.sendRedirect(request, response, targetUrl);
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("session失效");
        }
    }

    /**
     * session失效是否是并发导致的
     *
     * @return
     */
    protected boolean isConcurrency() {
        return false;
    }

    public void setCreateNewSession(boolean createNewSession) {
        this.createNewSession = createNewSession;
    }
}
