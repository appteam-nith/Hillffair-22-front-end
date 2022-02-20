package com.nith.hillfair2k22.Models;

public class Sponsor {
    String name;
    String image;
    String link;
    String position;
    int priority;

    public Sponsor() {
    }

    public Sponsor(String name, String image, String link, String position, int priority) {
        this.name = name;
        this.image = image;
        this.link = link;
        this.position = position;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
