package org.zhangbiao.security.core.validate.code.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.zhangbiao.security.core.properties.SecurityConstants;
import org.zhangbiao.security.core.validate.code.ValidateCode;
import org.zhangbiao.security.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * @author zhangbiao
 * @date 2019/11/16 0:42
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.sender(mobile, validateCode.getCode());
    }

}
