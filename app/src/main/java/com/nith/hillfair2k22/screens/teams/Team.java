package com.nith.hillfair2k22.screens.teams;

public class Team {
    private  String  Team_Name;
    private String TeamImage;



    public Team(String team_Name,String teamImage) {
        Team_Name = team_Name;
       TeamImage= teamImage;



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
