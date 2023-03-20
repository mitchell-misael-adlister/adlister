//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.User;
//import com.codeup.adlister.util.Config;
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.*;
//
//public class MySQLUsersDao implements Users {
//    private Connection connection = null;
//
//
//    //previous
//
//// private Connection connection;
//
//
//    public MySQLUsersDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    }
//
//    @Override
//    public String findByUsername(String username) {
//        try {
//            String sql = "SELECT * FROM users WHERE username = ?";
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//            String returnPassword = null;
//            while (rs.next()) {
//                returnPassword = rs.getString("password");
//            }
//            return returnPassword;
//        } catch (SQLException e) {
//            throw new RuntimeException("Error finding User.", e);
//        }
//    }
//
//    //previous
//
////
////    @Override
////    public User findByUsername(String username) {
////        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
////        try {
////            PreparedStatement stmt = connection.prepareStatement(query);
////            stmt.setString(1, username);
////            return extractUser(stmt.executeQuery());
////        } catch (SQLException e) {
////            throw new RuntimeException("Error finding a user by username", e);
////        }
////    }
//
//
//
//    @Override
//    public Long insert(User user) {
//        try {
//            String sql = "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)";
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getEmail());
//            stmt.setString(3, user.getPassword());
//            stmt.executeUpdate();
//            ResultSet generatedIdResultSet = stmt.getGeneratedKeys();
//            generatedIdResultSet.next();
//            return generatedIdResultSet.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
//
//
//    //previous
//
////
////    @Override
////    public Long insert(User user) {
////        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
////        try {
////            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
////            stmt.setString(1, user.getUsername());
////            stmt.setString(2, user.getEmail());
////            stmt.setString(3, user.getPassword());
////            stmt.executeUpdate();
////            ResultSet rs = stmt.getGeneratedKeys();
////            rs.next();
////            return rs.getLong(1);
////        } catch (SQLException e) {
////            throw new RuntimeException("Error creating new user", e);
////        }
////    }
//
//
//    public boolean isUsernameUnique(String username) {
//        try {
//            String sql = "SELECT * FROM users WHERE username = ?";
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//
//            // If there is a result, the username is not unique
//            return !rs.next();
//        } catch (SQLException e) {
//            throw new RuntimeException("Error checking for unique username.", e);
//        }
//    }
//
//    private User extractUser(ResultSet rs) throws SQLException {
//        return new User(
//                rs.getLong("id"),
//                rs.getString("username"),
//                rs.getString("email"),
//                rs.getString("password")
//        );
//    }
//}
//
////previous
//
//
////
////    private User extractUser(ResultSet rs) throws SQLException {
////        if (! rs.next()) {
////            return null;
////        }
////        return new User(
////                rs.getLong("id"),
////                rs.getString("username"),
////                rs.getString("email"),
////                rs.getString("password")
////        );
////    }
////
////}



package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        try {
            String sql = "INSERT INTO Users(username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet generatedIdResultSet = stmt.getGeneratedKeys();
            generatedIdResultSet.next();
            return generatedIdResultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    public boolean isUsernameUnique(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            // If there is a result, the username is not unique
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error checking for unique username.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}
