package com.example.testapiapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<RSSItem> itemList;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, List<RSSItem> itemList) {
        this.itemList = itemList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    public RSSItem getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.custom_list_item, null);
        }

        TextView titleTextView = view.findViewById(R.id.tv_title);
        TextView TimeTextView = view.findViewById(R.id.tv_time);

        RSSItem rssItem = getItem(i);

        titleTextView.setText(rssItem.getTitle());
        TimeTextView.setText(rssItem.getTime());

        return view;
    }


}
