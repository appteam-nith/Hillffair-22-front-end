package com.nith.hillfair2k22.screens.teams;

public class Team {
    private  String  Team_Name;
    private  String  Team_Member_Name;
    private  String  Designation;
    private String imageurl1;
    private String imageurl2;


    public Team(String team_Name, String team_Member_Name, String designation) {
        Team_Name = team_Name;
        Team_Member_Name = team_Member_Name;
        Designation = designation;
    }

    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String team_Name) {
        this.Team_Name = team_Name;
    }

    public String getTeam_Member_Name() {
        return Team_Member_Name;
    }

    public void setTeam_Member_Name(String team_Member_Name) {
        this.Team_Member_Name = team_Member_Name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        this.Designation = designation;
    }
}
