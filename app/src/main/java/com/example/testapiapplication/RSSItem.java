package com.example.testapiapplication;

import androidx.annotation.NonNull;

public class RSSItem {
    private final String title;
    private final String link;
    private final String description;
    private final String time;

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

    @NonNull
    public String toString() {
        return title;
    }


}
