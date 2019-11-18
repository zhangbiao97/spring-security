package org.zhangbiao.security.core.properties;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/15 19:44
 */
public class ImageCodeProperties extends SmsCodeProperties {

    private Integer width = 67;
    private Integer height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


}
