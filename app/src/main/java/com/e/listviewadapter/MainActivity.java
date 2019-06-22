package com.e.listviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_addPerson;
    EditText et_addPerson;
    ListView lv_listOfPeople;

    List<String> friends = new ArrayList<String>();
    String[] startingList = {"bobby","ricky","Chad","Luther"};

    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_addPerson = findViewById(R.id.btn_addPerson);
        et_addPerson = findViewById(R.id.et_addPerson);
        lv_listOfPeople = findViewById(R.id.lv_listOfPeople);

        friends = new ArrayList<String>(Arrays.asList(startingList));

        ad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, friends);

        lv_listOfPeople.setAdapter(ad);

        btn_addPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = et_addPerson.getText().toString();
                friends.add(newName);
                Collections.sort(friends);
                ad.notifyDataSetChanged();
            }
        });

        lv_listOfPeople.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Pos: " + i + " | Name: " + friends.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
