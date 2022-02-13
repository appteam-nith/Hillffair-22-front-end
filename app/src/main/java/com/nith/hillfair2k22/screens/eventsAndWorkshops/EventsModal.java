package com.nith.hillfair2k22.screens.eventsAndWorkshops;

public class EventsModal {

    private String eventTitle;
    private String eventDescription;
    private String eventStartDate;
    private String eventEndDate;
    private String eventClubName;
    private String eventPlatform;
    private String eventImageUrl;
    private String eventRegUrl;
    private boolean expanded;

    public EventsModal(String eventTitle, String eventDescription, String eventStartDate, String eventEndDate, String eventClubName, String eventPlatform, String eventImageUrl, String eventRegUrl, boolean expanded) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.eventClubName = eventClubName;
        this.eventPlatform = eventPlatform;
        this.eventImageUrl = eventImageUrl;
        this.eventRegUrl = eventRegUrl;
        this.expanded = expanded;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventClubName() {
        return eventClubName;
    }

    public void setEventClubName(String eventClubName) {
        this.eventClubName = eventClubName;
    }

    public String getEventPlatform() {
        return eventPlatform;
    }

    public void setEventPlatform(String eventPlatform) {
        this.eventPlatform = eventPlatform;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
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
