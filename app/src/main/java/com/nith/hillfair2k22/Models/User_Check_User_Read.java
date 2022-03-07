package com.nith.hillfair2k22.Models;

public class User_Check_User_Read {
    boolean response;

    public User_Check_User_Read() {
    }

    public User_Check_User_Read(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}