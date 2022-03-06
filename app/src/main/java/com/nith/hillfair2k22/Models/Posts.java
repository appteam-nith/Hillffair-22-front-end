package com.nith.hillfair2k22.Models;


public class Posts {
    String id;
    User_Serializer_For_ImageFeed author;
    String photo;
    String text;
    String location;
    String posted_on;
    String number_of_likes;
    String number_0f_comments;
    String post_comments;

    public Posts() {
    }

    public Posts(String id, User_Serializer_For_ImageFeed author, String photo, String text, String location, String posted_on, String number_of_likes, String number_0f_comments, String post_comments) {
        this.id = id;
        this.author = author;
        this.photo = photo;
        this.text = text;
        this.location = location;
        this.posted_on = posted_on;
        this.number_of_likes = number_of_likes;
        this.number_0f_comments = number_0f_comments;
        this.post_comments = post_comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User_Serializer_For_ImageFeed getAuthor() {
        return author;
    }

    public void setAuthor(User_Serializer_For_ImageFeed author) {
        this.author = author;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(String posted_on) {
        this.posted_on = posted_on;
    }

    public String getNumber_of_likes() {
        return number_of_likes;
    }

    public void setNumber_of_likes(String number_of_likes) {
        this.number_of_likes = number_of_likes;
    }

    public String getNumber_0f_comments() {
        return number_0f_comments;
    }

    public void setNumber_0f_comments(String number_0f_comments) {
        this.number_0f_comments = number_0f_comments;
    }

    public String getPost_comments() {
        return post_comments;
    }

    public void setPost_comments(String post_comments) {
        this.post_comments = post_comments;
    }
}

