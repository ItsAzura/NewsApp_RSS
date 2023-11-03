package com.example.testapiapplication;

public class RSSItem {
    private String title;
    private String link;
    private String description;
    private String time;

    public RSSItem(String title, String link, String description, String time) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getTime(){
        return time;
    }

    public String toString() {
        return title;
    }


}
