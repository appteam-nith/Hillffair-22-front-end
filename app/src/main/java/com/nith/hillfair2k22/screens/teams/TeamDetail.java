package com.nith.hillfair2k22.screens.teams;

public class TeamDetail {
    private  String  Team_Member_Name;
    private String Team_mem_Img;
    private  String  Designation;
    private  String  Team_Name;


    public TeamDetail(String team_Name, String team_Member_Name, String designation, String team_mem_Img) {
        Team_Member_Name = team_Member_Name;
        Designation = designation;
        Team_mem_Img = team_mem_Img;
        Team_Name=team_Name;
    }

    public String getTeam_Name1() {
        return Team_Name;
    }

    public void setTeam_Name(String team_Name) {
        Team_Name = team_Name;
    }

    public String getTeam_Member_Name() {
        return Team_Member_Name;
    }

    public void setTeam_Member_Name(String team_Member_Name) {
        Team_Member_Name = team_Member_Name;
    }

    public String getTeam_mem_Img() {
        return Team_mem_Img;
    }

    public void setTeam_mem_Img(String team_mem_Img) {
        Team_mem_Img = team_mem_Img;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }
}
