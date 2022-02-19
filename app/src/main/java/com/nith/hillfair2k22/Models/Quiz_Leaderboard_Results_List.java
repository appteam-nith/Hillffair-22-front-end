package com.nith.hillfair2k22.Models;

public class Quiz_Leaderboard_Results_List {
    int id;
    String user;
    int score;
    String timestamp;

    public Quiz_Leaderboard_Results_List() {
    }

    public Quiz_Leaderboard_Results_List(int id, String user, int score, String timestamp) {
        this.id = id;
        this.user = user;
        this.score = score;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
}
