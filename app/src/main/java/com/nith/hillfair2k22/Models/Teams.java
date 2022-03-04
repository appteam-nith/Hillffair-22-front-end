package com.nith.hillfair2k22.Models;

public class Teams {
    int id;
    String Club_name;
    String image;

    public Teams(int id, String club_name, String image) {
        this.id = id;
        Club_name = club_name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClub_name() {
        return Club_name;
    }

    public void setClub_name(String club_name) {
        Club_name = club_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
