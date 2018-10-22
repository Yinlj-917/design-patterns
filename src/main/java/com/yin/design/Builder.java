package com.yin.design;

/**
 * 创建型模式 - 创建者模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/22
 */
public class Builder {

    public static void main(String[] args) {
       UserFactory userFactory = new UserFactory();
       User user = userFactory.getInstanse();
    }
}

class User {
    private String name;

    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface AbUser {

    User getInstance();

    void setUser(String name, int age);
}

class UserBuilder implements AbUser {

    private User user = new User();

    public User getInstance() {
        return null;
    }

    public void setUser(String name, int age) {
        user.setAge(age);
        user.setName(name);
    }
}

class UserFactory {
    public User getInstanse() {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.setUser("lijian.yin", 18);
        return userBuilder.getInstance();
    }
}