//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Ad;
//
//import java.util.List;
//
//public interface Ads {
//    // get a list of all the ads
//    List<Ad> all();
//    // insert a new ad and return the new ad's id
//    Long insert(Ad ad);
//}


package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    List<Ad> all();
    Long insert(Ad ad);
    Ad findById(Long id); // Add this line
}
