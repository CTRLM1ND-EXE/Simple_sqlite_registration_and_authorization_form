package com.example.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simple_sqlite_registration_and_authorization_form.R;

public class UserActivity extends AppCompatActivity {
    private TextView textName,textSurname,textNumberPhone;
    private EditText editTextUserName,editTextUserSurname,editTextUserNumberPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().hide();

        textName = (TextView)findViewById(R.id.textViewName);
        textSurname = (TextView)findViewById(R.id.textViewSurname);
        textNumberPhone = (TextView)findViewById(R.id.textViewNumberPhone);

        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        editTextUserSurname = (EditText)findViewById(R.id.editTextUserSurname);
        editTextUserNumberPhone = (EditText)findViewById(R.id.editTextUserNumberPhone);

        editTextUserName.setText(RegisterActivity.NAME_REG);
        editTextUserSurname.setText(RegisterActivity.SURNAME_REG);
        editTextUserNumberPhone.setText(RegisterActivity.NUMBER_REG);

    }
}