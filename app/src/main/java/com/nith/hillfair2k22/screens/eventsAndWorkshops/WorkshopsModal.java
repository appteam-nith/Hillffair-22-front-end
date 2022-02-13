package com.nith.hillfair2k22.screens.eventsAndWorkshops;

public class WorkshopsModal {

    private String wrShpTitle;
    private String wrShpDescription;
    private String wrShpStartDate;
    private String wrShpEndDate;
    private String wrShpClubName;
    private String wrShpPlatform;
    private String wrShpImageUrl;
    private String wrShpRegUrl;
    private boolean expanded;

    public WorkshopsModal(String wrShpTitle, String wrShpDescription, String wrShpStartDate, String wrShpEndDate, String wrShpClubName, String wrShpPlatform, String wrShpImageUrl, String wrShpRegUrl, boolean expanded) {
        this.wrShpTitle = wrShpTitle;
        this.wrShpDescription = wrShpDescription;
        this.wrShpStartDate = wrShpStartDate;
        this.wrShpEndDate = wrShpEndDate;
        this.wrShpClubName = wrShpClubName;
        this.wrShpPlatform = wrShpPlatform;
        this.wrShpImageUrl = wrShpImageUrl;
        this.wrShpRegUrl = wrShpRegUrl;
        this.expanded = expanded;
    }

    public String getWrShpTitle() {
        return wrShpTitle;
    }

    public void setWrShpTitle(String wrShpTitle) {
        this.wrShpTitle = wrShpTitle;
    }

    public String getWrShpDescription() {
        return wrShpDescription;
    }

    public void setWrShpDescription(String wrShpDescription) {
        this.wrShpDescription = wrShpDescription;
    }

    public String getWrShpStartDate() {
        return wrShpStartDate;
    }

    public void setWrShpStartDate(String wrShpStartDate) {
        this.wrShpStartDate = wrShpStartDate;
    }

    public String getWrShpEndDate() {
        return wrShpEndDate;
    }

    public void setWrShpEndDate(String wrShpEndDate) {
        this.wrShpEndDate = wrShpEndDate;
    }

    public String getWrShpClubName() {
        return wrShpClubName;
    }

    public void setWrShpClubName(String wrShpClubName) {
        this.wrShpClubName = wrShpClubName;
    }

    public String getWrShpPlatform() {
        return wrShpPlatform;
    }

    public void setWrShpPlatform(String wrShpPlatform) {
        this.wrShpPlatform = wrShpPlatform;
    }

    public String getWrShpImageUrl() {
        return wrShpImageUrl;
    }

    public void setWrShpImageUrl(String wrShpImageUrl) {
        this.wrShpImageUrl = wrShpImageUrl;
    }

    public String getWrShpRegUrl() {
        return wrShpRegUrl;
    }

    public void setWrShpRegUrl(String wrShpRegUrl) {
        this.wrShpRegUrl = wrShpRegUrl;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
