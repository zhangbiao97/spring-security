package org.zhangbiao.security.core.validate.code.image;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.zhangbiao.security.core.validate.code.ImageCode;
import org.zhangbiao.security.core.validate.code.impl.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;

/**
 * @author zhangbiao
 * @date 2019/11/16 0:42
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     *
     * @param request
     * @param imageCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }
}
