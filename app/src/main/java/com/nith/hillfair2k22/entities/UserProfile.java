package com.nith.hillfair2k22.entities;

public class UserProfile {
    String name;
    String rollNO;
    String phoneNo;
    String instaID;
    public UserProfile(String name, String rollNO, String phoneNo, String instaID) {
        this.name = name;
        this.rollNO = rollNO;
        this.phoneNo = phoneNo;
        this.instaID = instaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNO() {
        return rollNO;
    }

    public void setRollNO(String rollNO) {
        this.rollNO = rollNO;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getInstaID() {
        return instaID;
    }

    public void setInstaID(String instaID) {
        this.instaID = instaID;
    }
}
