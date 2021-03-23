package com.ssm.assemble.pojo;

import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<String> list;

    /**
     * 使用有参构造方法注入
     *
     * @param userName
     * @param password
     * @param list
     */
    public User(String userName, String password, List<String> list) {
        super();
        this.userName = userName;
        this.password = password;
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                '}';
    }

    /**
     * 使用无参构造方法注入时，需要提供setter方法
     */
    public User() {
        super();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
