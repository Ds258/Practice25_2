package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    Button buttonAdd2;
    EditText editName;
    EditText editID;
    EditText editPhone;
    ContactData contactData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        Intent intent = getIntent();
        buttonAdd2 = (Button) findViewById(R.id.buttonAdd2);
        buttonAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editID = (EditText) findViewById(R.id.editTextID);
                editName = (EditText) findViewById(R.id.editTextTextPersonName);
                editPhone = (EditText) findViewById(R.id.editTextPhoneNumber);
                int id = Integer.parseInt(editID.getText().toString());
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();
                //contactData = new ContactData(id, "img", name, phone);
                //Bundle bundle = new Bundle();
                //bundle.putInt("id", id);
                //bundle.putString("img", "img");
                //bundle.putString("name", name);
                //bundle.putString("phone", phone);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("id", id);
                resultIntent.putExtra("img", "img");
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("phone", phone);
                //startActivity(intent);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
