package com.codeup.adlister.dao;

import com.codeup.adlister.models.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;


public class MySQLUsersDao implements Users {

    private Connection connection = null;

    public MySQLUsersDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving the user by username", e);
        }
        return user;
    }

    @Override
    public long insertUser(User user) {
        long newId = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (username, email, password) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            newId = rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new user into the database");
        }

        return newId;
    }

    @Override
    public void update(User user) {

        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE users SET email=? WHERE id=?");


            stmt.setString(1, user.getEmail());
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating Profile information", e);
        }

    }

    public void updatePassword(User user) {

        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE users SET password=? WHERE id=?");


            stmt.setString(1, user.getPassword());
            stmt.setLong(2, user.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating password", e);
        }

    }


}
