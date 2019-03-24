package com.mutou.dubbo.demo.dao;

import java.io.Serializable;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.dao <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
public class User extends Person implements Serializable{
    private long id;
    private String sex;

    public User() {
        super();
    }

    public User(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    public User(String name, int age, long id, String sex) {
        super(name, age);
        this.id = id;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
