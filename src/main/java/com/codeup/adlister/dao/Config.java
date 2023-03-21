package com.codeup.adlister.dao;

public class Config {
    public String getUrl() {
        return "jdbc:mysql://studentdb.fulgentcorp.com/ymir_adlister_2?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public String getUser() {
        return "ymir_adlister_2";
    }

    public String getPassword() {
        return "tomato";
    }
}
