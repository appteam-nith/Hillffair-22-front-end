package com.nith.hillfair2k22.Models;

public class User_List {
    String firebaseId;
    String username;
    String phone;
    String email;
    String name;
    String instagramId;
    String profileImage;

    public User_List() {
    }

    public User_List(String firebaseId, String username, String phone, String email, String name, String instagramId, String profileImage) {
        this.firebaseId = firebaseId;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.instagramId = instagramId;
        this.profileImage = profileImage;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagramId() {
        return instagramId;
    }

    public void setInstagramId(String instagramId) {
        this.instagramId = instagramId;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
