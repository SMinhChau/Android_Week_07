package com.example.android_week_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditNameTravel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name_travel);

        Travel travel= (Travel) getIntent().getSerializableExtra("travel");
        EditText name= findViewById(R.id.textViewEdit);
        Button button= findViewById(R.id.btnEdit);
        name.setText(travel.getName());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                travel.setName(name.getText().toString());
                MainTravel.dataBaseTravel.updateTravel(travel);
                onBackPressed();

                MainTravel.loadlistView();

            }
        });

    }
}