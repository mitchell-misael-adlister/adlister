package dao;

import models.Ad;

import java.util.List;

public interface Ads {
    List<Ad> getAllAds();
    List<Ad> getAdsByUser(long id);
    long insertAd(Ad ad);
    Ad getAdById(long id);
    List<Ad> getNewestAds(int limit);
    void deleteAd(Ad ad);
    void updateAd(Ad ad);
    List<Ad> getDeletedAds();
}