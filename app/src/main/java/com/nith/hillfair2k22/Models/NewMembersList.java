package com.nith.hillfair2k22.Models;

public class NewMembersList {
    int id;
    String name;
    String position;
    String image;

    public NewMembersList() {
    }

    public NewMembersList(int id, String name, String position, String image) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
