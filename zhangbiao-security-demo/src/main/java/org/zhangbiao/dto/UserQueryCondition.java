package org.zhangbiao.dto;

public class UserQueryCondition {

    private String username;
    private Integer age;
    private Integer ageTo;
    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UserQueryCondition{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", ageTo=" + ageTo +
                ", xxx='" + xxx + '\'' +
                '}';
    }
}
