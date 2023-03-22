package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDAO implements Ads {
    private Connection connection = null;

    MySQLAdsDAO() {
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
    public List<Ad> getAllAds() {
        List<Ad> ads = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE is_deleted=0");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads from the database", e);
        }

        return ads;
    }

    @Override
    public List<Ad> getAdsByUser(long id) {
        List<Ad> adsByUser = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ? AND is_deleted= 0");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                adsByUser.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by a user from the database", e);
        }

        return adsByUser;
    }

    @Override
    public long insertAd(Ad ad) {
        long newId;

        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO ads (user_id, title, description) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            newId = rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new ad into the database", e);
        }

        return newId;
    }

    @Override
    public Ad getAdById(long id) {
        Ad ad = null;

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? AND is_deleted=0");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad from the database", e);
        }

        return ad;
    }

    @Override
    public List<Ad> getNewestAds(int limit) {
        List<Ad> newestAds = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE is_deleted=0");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                newestAds.add(new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Error retrieving the newest %s ads", limit), e);
        }

        return newestAds;
    }

    @Override
    public void deleteAd(Ad ad) {
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE ads SET is_deleted=? WHERE id=?");

            stmt.setBoolean(1, true);
            stmt.setLong(2, ad.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating Profile information", e);
        }

    }

    @Override
    public void updateAd(Ad ad) {
        try{
            PreparedStatement stmt = connection.prepareStatement("UPDATE ads SET title=?, description=? WHERE id=?");


            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setLong(3, ad.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating Ad information", e);
        }
    }

    @Override
    public List<Ad> getDeletedAds() {
        List<Ad> ads = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ads WHERE is_deleted=1");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads from the database", e);
        }

        return ads;
    }

}