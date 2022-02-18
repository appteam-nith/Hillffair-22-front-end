package com.nith.hillfair2k22.screens.eventsAndWorkshops;

public class EventsModal {

    private String eventTitle;
    private String eventStartDate;
    private String eventClubName;
    private String eventRegUrl;
    private String eventDescription;
    private String imageUrl;


    public EventsModal(String eventTitle, String eventStartDate, String eventClubName, String eventRegUrl, String eventDescription,String imageUrl) {
        this.eventTitle = eventTitle;
        this.eventStartDate = eventStartDate;
        this.eventClubName = eventClubName;
        this.eventRegUrl = eventRegUrl;
        this.eventDescription = eventDescription;
        this.imageUrl = imageUrl;
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

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
