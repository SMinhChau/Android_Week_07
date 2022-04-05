package com.example.android_week_07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Person> arrayList;

    public PersonAdapter(Context context, int layout, List<Person> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(layout,viewGroup,false);

        TextView name= view.findViewById(R.id.textVName);

       name.setText(arrayList.get(i).getName());
        return view;
    }
}
