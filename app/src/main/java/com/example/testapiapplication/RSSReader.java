package com.example.testapiapplication;

import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;

public class RSSReader {
    public static List<RSSItem> readRSS(String url) throws IOException {
        List<RSSItem> itemList = new ArrayList<>();

        Document document = Jsoup.connect(url).get();
        Elements items = document.select("item");

        for (Element item : items) {
            String title = item.select("title").text();
            String link = item.select("link").text();
            String description = item.select("description").text();
            String time = item.select("pubDate").text();

            RSSItem rssItem = new RSSItem(title, link, description,time);
            itemList.add(rssItem);
        }

        return itemList;
    }
}
