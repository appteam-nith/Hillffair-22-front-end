package com.nith.hillfair2k22.Models;

public class NewCommentRead {
    int id;
    User_Serializer_For_ImageFeed author;
    String text;
    String posted_on;

    public NewCommentRead() {
    }

    public NewCommentRead(int id, User_Serializer_For_ImageFeed author, String text, String posted_on) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.posted_on = posted_on;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User_Serializer_For_ImageFeed getAuthor() {
        return author;
    }

    public void setAuthor(User_Serializer_For_ImageFeed author) {
        this.author = author;
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
