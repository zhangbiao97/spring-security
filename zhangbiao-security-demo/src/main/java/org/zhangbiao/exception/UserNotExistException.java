package org.zhangbiao.exception;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 21:42
 */
public class UserNotExistException extends RuntimeException {

    private Integer id;

    public UserNotExistException(Integer id) {
        super("user not exist");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
