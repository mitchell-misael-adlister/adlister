package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;

public interface Users {
    User getUserByUsername(String username);
    long insertUser(User user);
    void update(User user);
    void updatePassword(User user);
}
