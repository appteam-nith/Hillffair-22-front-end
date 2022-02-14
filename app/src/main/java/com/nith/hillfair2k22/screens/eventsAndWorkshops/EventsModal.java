package com.nith.hillfair2k22.screens.eventsAndWorkshops;

public class EventsModal {

    private String eventTitle;
    private String eventStartDate;
    private String eventClubName;
    private String eventRegUrl;
    private boolean expanded;

    public EventsModal(String eventTitle, String eventClubName,String eventStartDate, boolean expanded) {
        this.eventTitle = eventTitle;
        this.eventStartDate = eventStartDate;
        this.eventClubName = eventClubName;
        this.eventRegUrl = null;
        this.expanded = false;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }



    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }



    public String getEventClubName() {
        return eventClubName;
    }

    public void setEventClubName(String eventClubName) {
        this.eventClubName = eventClubName;
    }

    public String getEventRegUrl() {
        return eventRegUrl;
    }

    public void setEventRegUrl(String eventRegUrl) {
        this.eventRegUrl = eventRegUrl;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
