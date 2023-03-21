package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    List<Ad> all();

    Long insert(Ad ad);

    Ad findUniqueAdId(Long ad);

    void delete(Ad ad);

    void edit(Ad ad, String title, String description);

    List<Ad> searchAds(String searchString) throws SQLException;
}
