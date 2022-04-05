package com.example.android_week_07;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TravelAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Travel> listTravels;

    public TravelAdapter(Context context, int layout, List<Travel> listTravels) {
        this.context = context;
        this.layout = layout;
        this.listTravels = listTravels;
    }

    @Override
    public int getCount() {
        return listTravels.size();
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

        TextView name= view.findViewById(R.id.nameTravel);
        ImageView imgDelete= view.findViewById(R.id.btnImgRemove);
        ImageView imgUpdate= view.findViewById(R.id.btnImgUpdate);
       TextView id= view.findViewById(R.id.idTravel);
       Travel travel= listTravels.get(i);

       id.setText(i+1+".");
        name.setText(travel.getName());



        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainTravel.dataBaseTravel.deleteTravel(listTravels.get(i));
                MainTravel.listView.setAdapter(new TravelAdapter(context,
                        R.layout.item_listtravel_2,MainTravel.dataBaseTravel.getAllTravel()));
            }
        });

        imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,EditNameTravel.class);
                intent.putExtra("travel",listTravels.get(i));
                context.startActivity(intent);

            }
        });
        return view;
    }
}
