package com.codeup.adlister.models;
import java.sql.Timestamp;

public class Ad {
    private long userId;
    private long id;
    private String title;
    private String description;
    private Timestamp timeCreated;

    public Ad() { }

    public Ad(long id, long userId, String title, String description){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {

        if (description.length() >= 30) {
            String shortDescription = description.substring(0, 30) + "...";
            return shortDescription;
        } else {
            String shortDescription = description;
            return shortDescription;
        }

    }

    public void setDescription(String description) {
        this.description = description;
    }
}
