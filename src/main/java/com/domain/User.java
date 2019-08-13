package com.domain;

import java.util.List;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author acer
 * @Date 2019/8/6 9:21
 * @Version 1.0
 **/
public class User {

    private String name;
    private int age;
    public List<String> des;

    public void t(List<User> list){
        System.out.println("-----");
    }
    public User() {
    }

    private User(String name, int age) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", des='" + des + '\'' +
                '}';
    }
}
