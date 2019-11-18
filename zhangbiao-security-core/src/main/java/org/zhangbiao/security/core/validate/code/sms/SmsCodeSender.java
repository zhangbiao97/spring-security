package org.zhangbiao.security.core.validate.code.sms;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 23:10
 */
public interface SmsCodeSender {

    void sender(String mobile, String code);

}
