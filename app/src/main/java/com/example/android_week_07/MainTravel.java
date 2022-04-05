package com.example.android_week_07;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MainTravel extends AppCompatActivity {
    protected static ListView listView;
    private TextView textViewName,txtId,nameTravel;
    private List<Travel> travelList;
    protected static DataBaseTravel dataBaseTravel;
    private Button btnAdd, btnCancel;
    protected static Context context;
    private TravelAdapter adapter;
    int position= -1;

   

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_advance_custom_listtravle_2);
        context = this;
        listView= findViewById(R.id.idListViewTravel);
        textViewName=findViewById(R.id.inputTextTravel);
        txtId = findViewById(R.id.idTravel);
        nameTravel = findViewById(R.id.nameTravel);
        btnAdd= findViewById(R.id.btnSave);
        btnCancel=findViewById(R.id.btnCancelTravel);


        dataBaseTravel=  new DataBaseTravel(this) ;
        travelList= new ArrayList<>();
        loadlistView();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                Toast.makeText(MainTravel.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textViewName.getText().toString();
                textViewName.setText("");
                dataBaseTravel.addTravel(new Travel(name));
                updateDataList();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDataList();
            }
        });

    }

    public static void loadlistView() {

         TravelAdapter adapter= new TravelAdapter(context,R.layout.item_listtravel_2,dataBaseTravel.getAllTravel());
        listView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        SharedPreferences sharedPreferences= getSharedPreferences("SharedPreferences",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("name",textViewName.getText().toString());
        editor.apply();
        super.onPause();

    }

    private void updateDataList(){
        travelList.clear();
        List<Travel> temp = dataBaseTravel.getAllTravel();
        for (Travel n : temp){
            travelList.add(n);
        }
        adapter.notifyDataSetChanged();
    }
}
