package com.nith.hillfair2k22.screens.teams;

public class Team {
    private  String  Team_Name;
    private String TeamImage;
    private  String  Team_Member_Name;
    private  String  Designation;
    private String Team_mem_Img;

    public Team(String team_Name, String teamImage, String team_Member_Name, String designation, String team_mem_Img) {
        Team_Name = team_Name;
        TeamImage = teamImage;
        Team_Member_Name = team_Member_Name;
        Designation = designation;
        Team_mem_Img = team_mem_Img;
    }

    public String getTeam_Member_Name() {
        return Team_Member_Name;
    }

    public void setTeam_Member_Name(String team_Member_Name) {
        Team_Member_Name = team_Member_Name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getTeam_mem_Img() {
        return Team_mem_Img;
    }

    public void setTeam_mem_Img(String team_mem_Img) {
        Team_mem_Img = team_mem_Img;
    }

    public Team(String team_Member_Name, String designation, String team_mem_Img) {
        Team_Member_Name = team_Member_Name;
        Designation = designation;
        Team_mem_Img = team_mem_Img;
    }

    public Team(String team_Name, String teamImage) {
        Team_Name = team_Name;
        TeamImage = teamImage;
    }


    public String getTeam_Name() {
        return Team_Name;
    }

    public void setTeam_Name(String team_Name) {
        this.Team_Name = team_Name;
    }

    public String getTeamImage(){
        return TeamImage;
    }

    public void setTeamImage(String teamImage) {
     this.TeamImage=teamImage;
    }

}
