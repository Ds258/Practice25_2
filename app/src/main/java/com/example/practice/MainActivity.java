package com.example.practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ContactData> listContact;
    private Adapter listApdater;
    private ListView listView;
    private Button buttonAdd;
    private Button buttonDelete;
    private Bundle bundle;
    private ContactData contactData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        listContact = new ArrayList<>();
        //listContact.add(new ContactData(1, "img1", "Phùng Minh Đức", "123456789"));

        listApdater = new Adapter(listContact, this);
        listView = (ListView)findViewById(R.id.ListViewContact);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                //startActivity(intent);

                startActivityForResult(intent, 1);
                //listApdater.notifyDataSetChanged();

            }
        });

        buttonDelete.setOnClickListener(view -> {
            //SparseBooleanArray checked = listView.getCheckedItemPositions();
            for(int i = listView.getChildCount() - 1; i >= 0; i--){
                View v = listView.getChildAt(i);
                CheckBox checkBox;
                checkBox = v.findViewById(R.id.checkBox);
                if(checkBox.isChecked()){
                    listContact.remove(i);
                }

            }
            listApdater.notifyDataSetChanged();
            //listView.clearChoices();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                //bundle = getIntent().getExtras();
                //final int id = (int)bundle.getInt("id");
                //final String name = bundle.getString("name").toString();
                //final String phoneNumber = bundle.getString("phone").toString();
                int id = data.getIntExtra("id", 0);
                String name = data.getStringExtra("name");
                String phoneNumber = data.getStringExtra("phone");
                //listContact.add(new ContactData(1, "img1", "Phùng Minh Đức", "123456789"));
                //listContact.add(new ContactData(1, "img1", "Phùng Minh Đức", "123456789"));
                listContact.add(new ContactData(id, "img", name, phoneNumber));
                listView.setAdapter(listApdater);
            }
        }
    }
}