package dao;

import models.User;

public interface Users {
    User getUserByUsername(String username);
    long insertUser(User user);
    void update(User user);
    void updatePassword(User user);
}
