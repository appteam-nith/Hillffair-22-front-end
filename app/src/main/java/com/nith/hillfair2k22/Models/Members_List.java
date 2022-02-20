package com.nith.hillfair2k22.Models;

public class Members_List {
    String name;
    String position;
    String image;

    public Members_List() {
    }

    public Members_List(String name, String position, String image) {
        this.name = name;
        this.position = position;
        this.image = image;
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
