package com.nith.hillfair2k22.Models;

public class NewUserList {
    String firebase;
    String username;
    String phone;
    String email;
    int score;
    String instagramId;
    String profileImage;

    public NewUserList() {
    }

    public NewUserList(String firebase, String username, String phone, String email, int score, String instagramId, String profileImage) {
        this.firebase = firebase;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.score = score;
        this.instagramId = instagramId;
        this.profileImage = profileImage;
    }

    public String getFirebase() {
        return firebase;
    }

    public void setFirebase(String firebase) {
        this.firebase = firebase;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
