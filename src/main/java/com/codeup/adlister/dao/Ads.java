package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {

    List<Ad> getAllAds();
    List<Ad> getAdsByUser(long id);
    long insert(Ad ad);
    Ad getAdById(long id);
    List<Ad> getNewestAds(int limit);
    void deleteAd(Ad ad);
    void update(Ad ad);
    List<Ad> getDeletedAds();
}