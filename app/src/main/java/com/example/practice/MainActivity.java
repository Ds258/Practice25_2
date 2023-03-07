package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ContactData> listContact;
    private Adapter listApdater;
    private ListView listView;
    private Button buttonAdd;
    private Bundle bundle;
    private ContactData contactData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        bundle = getIntent().getExtras();

        if(bundle != null){
            int id = (int)bundle.getInt("id");
            String name = bundle.getString("name").toString();
            String phoneNumber = bundle.getString("phone").toString();

            listContact = new ArrayList<>();

            //listContact.add(new ContactData(1, "img1", "Phùng Minh Đức", "123456789"));
            //listContact.add(new ContactData(1, "img1", "Phùng Minh Đức", "123456789"));
            listContact.add(new ContactData(id, "img", name, phoneNumber));
            listApdater = new Adapter(listContact, this);
            listView = (ListView)findViewById(R.id.ListViewContact);
            listView.setAdapter(listApdater);


        }

    }
}