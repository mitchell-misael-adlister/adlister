package com.codeup.adlister.dao;

import com.codeup.adlister.util.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
    protected Connection connection = null;

    public BaseDao(Config config) {
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
}


//    Creating an abstract class BaseDao and having both MySQLAdsDao and MySQLUsersDao inherit from it provides several benefits:
//
//        Code Reusability: By moving the common database connection code to the BaseDao class,
//        you eliminate code duplication in the MySQLAdsDao and MySQLUsersDao classes.
//        This practice is in line with the DRY (Don't Repeat Yourself) principle, making the code more maintainable.
//
//        Abstraction: The BaseDao class provides a level of abstraction,
//        which simplifies the code in both MySQLAdsDao and MySQLUsersDao.
//        This abstraction makes it easier to understand the code since each class focuses on its specific functionality.
//
//        Easier Maintenance: If you need to change the way the database connection is established,
//        you only have to modify the BaseDao class instead of updating the code in both MySQLAdsDao and MySQLUsersDao.
//        This centralization of the connection logic makes it easier to maintain and update the codebase.
//
//        Extensibility: If you decide to add more Data Access Object (DAO) classes in the future,
//        they can also inherit from BaseDao and reuse the connection logic, making the development process more efficient.