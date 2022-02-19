package com.nith.hillfair2k22.Models;

public class Quiz_List {
    String id;
    String name;
    String count;
    String sendCount;
    String startTime;
    String endTime;

    public Quiz_List() {
    }

    public Quiz_List(String id, String name, String count, String sendCount, String startTime, String endTime) {
        this.id = id;
        this.name = name;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSendCount() {
        return sendCount;
    }

    public void setSendCount(String sendCount) {
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
