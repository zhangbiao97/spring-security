package org.zhangbiao.dto;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/14 12:34
 */
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
