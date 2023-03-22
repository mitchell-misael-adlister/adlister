package dao;

import models.Ad;

public class DaoFactory {
    private static Users usersDao = null;
    private static Ads adsDao = null;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }

        return usersDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDAO();
        }

        return adsDao;
    }
}
