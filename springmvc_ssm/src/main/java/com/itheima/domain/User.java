package com.itheima.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类：在数据传输的时候可以用来封装了
 * @author sqh
 * @create 2021-06-05
 */
public class User implements Serializable {//通常在后面序列号
    private Integer uuid;
    private String userName;
    private String password;
    private String realName;
    private Integer gender;
    private Date birthday;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                ", brithday=" + birthday +
                '}';
    }
}
