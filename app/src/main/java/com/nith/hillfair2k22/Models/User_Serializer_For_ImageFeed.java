package com.nith.hillfair2k22.Models;

public class User_Serializer_For_ImageFeed {
    String username;

    public User_Serializer_For_ImageFeed() {
    }

    public User_Serializer_For_ImageFeed(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
