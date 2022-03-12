package com.nith.hillfair2k22.Models;

public class Quiz_List {
    String id;
    String name;
    String clubName;
    int count;
    int sendCount;
    String startTime;
    String endTime;

    public Quiz_List(String id, String name, String clubName, int count, int sendCount, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.clubName = clubName;
        this.count = count;
        this.sendCount = sendCount;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSendCount() {
        return sendCount;
    }

    public void setSendCount(int sendCount) {
        this.sendCount = sendCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
