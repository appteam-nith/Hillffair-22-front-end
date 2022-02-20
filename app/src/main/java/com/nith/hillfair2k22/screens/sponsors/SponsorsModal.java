package com.nith.hillfair2k22.screens.sponsors;

public class SponsorsModal {

    private String namme;
    private String link;
    private String imageUrl;

    public SponsorsModal(String namme, String link, String imageUrl) {
        this.namme = namme;
        this.link = link;
        this.imageUrl = imageUrl;
    }

    public String getNamme() {
        return namme;
    }

    public void setNamme(String namme) {
        this.namme = namme;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
