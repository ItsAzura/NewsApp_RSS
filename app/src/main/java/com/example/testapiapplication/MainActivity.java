package com.example.testapiapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        new AsyncTask<Void, Void, List<RSSItem>>() {
            @Override
            protected List<RSSItem> doInBackground(Void... voids) {
                try {
                    return RSSReader.readRSS("https://rss.nytimes.com/services/xml/rss/nyt/World.xml");
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<RSSItem> rssItems) {
                if (rssItems != null) {
                    CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, rssItems);
                    listView.setAdapter(adapter);
                }
            }
        }.execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RSSItem selectedRSSItem = (RSSItem) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", selectedRSSItem.getTitle());
                intent.putExtra("description", selectedRSSItem.getDescription());
                intent.putExtra("link", selectedRSSItem.getLink());
                intent.putExtra("pubDate", selectedRSSItem.getTime());

                startActivity(intent);

            }
        });
    }
}


