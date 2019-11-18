package org.zhangbiao.security.core.validate.code.sms;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 23:13
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void sender(String mobile, String code) {
        System.out.println("向手机号" + mobile + "发送验证码：" + code);
    }
}
