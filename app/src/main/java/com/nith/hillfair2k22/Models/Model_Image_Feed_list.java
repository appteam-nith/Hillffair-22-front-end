package com.nith.hillfair2k22.Models;

public class Model_Image_Feed_list {
    public String id,username,photo,text,location,posted_on,number_of_likes,number_of_comments,post_comments;

    public Model_Image_Feed_list(String id, String username, String photo, String text, String location, String posted_on, String number_of_likes, String number_of_comments, String post_comments) {
        this.id = id;
        this.username = username;
        this.photo = photo;
        this.text = text;
        this.location = location;
        this.posted_on = posted_on;
        this.number_of_likes = number_of_likes;
        this.number_of_comments = number_of_comments;
        this.post_comments = post_comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getNumber_of_comments() {
        return number_of_comments;
    }

    public void setNumber_of_comments(String number_of_comments) {
        this.number_of_comments = number_of_comments;
    }

    public String getPost_comments() {
        return post_comments;
    }

    public void setPost_comments(String post_comments) {
        this.post_comments = post_comments;
    }
}
