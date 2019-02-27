package com.dajiabao.readsource;

/**
 * Created by wangc on 2018/10/18
 * E-MAIL:274281610@QQ.COM
 */
public class User {
    private  int age;
    private String name;

    private User(Builder builder) {
        age = builder.age;
        name = builder.name;
    }

    public static final class Builder {
        private int age;
        private String name;

        public Builder() {
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
