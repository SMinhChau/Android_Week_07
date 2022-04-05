package com.example.android_week_07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private TextView textViewName;
    private List<Person> arrayList;
    private DataBasePerson dataBasePerson;
    private Button btnAdd, btnRemove, btnCancel;
    private PersonAdapter adapter;
    int position=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basis_sqlite);

        listView= findViewById(R.id.IdListView);
        textViewName=findViewById(R.id.tvName);
        btnAdd=findViewById(R.id.btnAdd);
        btnRemove= findViewById(R.id.btnCancel);
        btnRemove= findViewById(R.id.btnRemove);

        dataBasePerson= new DataBasePerson(this);
        arrayList= new ArrayList<>();
        arrayList= dataBasePerson.getAllPersons();

//        Log.d( "onCreate: ",arrayList.get(0).getName());

          adapter= new PersonAdapter(this,R.layout.persion_item,arrayList);
//        System.out.println("-------------"+adapter);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
//        https://stackoverflow.com/questions/60508944/android-studio-making-a-selection-turns-on-the-insert-key

    btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name = textViewName.getText().toString();
        textViewName.setText("");
        dataBasePerson.addPerson(new Person(name));
        updateDataList();

    }
});
    btnRemove.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dataBasePerson.deletePerson(arrayList.get(position));
            updateDataList();
        }
    });



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
        arrayList.clear();
        List<Person> temp = dataBasePerson.getAllPersons();
        for (Person n : temp){
            arrayList.add(n);
        }
        adapter.notifyDataSetChanged();
    }
}