package com.example.android_week_07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Person> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basis_sqlite);
        listView= findViewById(R.id.IdListView);

        DataBasePerson dataBasePerson= new DataBasePerson(this);

        arrayList= dataBasePerson.getAllPersons();

//        Log.d( "onCreate: ",arrayList.get(0).getName());

         PersonAdapter adapter= new PersonAdapter(this,R.layout.persion_item,arrayList);
        System.out.println("-------------"+adapter);
        listView.setAdapter(adapter);

//    DatabaseHandler db = new DatabaseHandler(this);
//
//    // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));
//
//    // Reading all contacts
//        Log.d("Reading: ", "Reading all contacts..");
//    List<Contact> contacts = db.getAllContacts();
//
//        for (Contact cn : contacts) {
//        String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
//                cn.getPhoneNumber();
//        // Writing Contacts to log
//        Log.d("Name: ", log);
//    }
//
}
}