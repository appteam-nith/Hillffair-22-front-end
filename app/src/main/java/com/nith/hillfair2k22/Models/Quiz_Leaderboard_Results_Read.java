package com.nith.hillfair2k22.Models;

public class Quiz_Leaderboard_Results_Read {
    int id;
    String username;
    String profileImage;
    int score;
    String timestamp;
    String quiz;

    public Quiz_Leaderboard_Results_Read() {
    }

    public Quiz_Leaderboard_Results_Read(int id, String username, String profileImage, int score, String timestamp, String quiz) {
        this.id = id;
        this.username = username;
        this.profileImage = profileImage;
        this.score = score;
        this.timestamp = timestamp;
        this.quiz = quiz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
}
