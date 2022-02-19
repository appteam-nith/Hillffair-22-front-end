package com.nith.hillfair2k22.Models;

public class Comment_Read {
    int id;
    String username;
    String text;
    String posted_on;

    public Comment_Read() {
    }

    public Comment_Read(int id, String username, String text, String posted_on) {
        this.id = id;
        this.username = username;
        this.text = text;
        this.posted_on = posted_on;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(String posted_on) {
        this.posted_on = posted_on;
    }
}
