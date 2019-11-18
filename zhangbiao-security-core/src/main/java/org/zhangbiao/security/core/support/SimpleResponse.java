package org.zhangbiao.security.core.support;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 20:08
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
