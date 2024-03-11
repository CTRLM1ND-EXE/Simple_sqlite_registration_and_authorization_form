package com.example.mainActivity;

import static com.example.mainActivity.RegisterActivity.NAME_REG;
import static com.example.mainActivity.RegisterActivity.SURNAME_REG;
import static com.example.mainActivity.RegisterActivity.openHelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simple_sqlite_registration_and_authorization_form.R;

public class MainActivity extends AppCompatActivity {

    private Button Button_reg,Button_login;
    private EditText NumberPhone_main,Password_main;

    public SQLiteOpenHelper sqLiteOpenHelper;

    private  Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Button_reg = (Button) findViewById(R.id.button_registration);
        Button_login = (Button)findViewById(R.id.button_log);
        NumberPhone_main = (EditText)findViewById(R.id.editNumberPhone);
        Password_main = (EditText)findViewById(R.id.editPassword);








    Button_reg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    });


    Button_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DataBaseSQLite dataBaseSQLite = new DataBaseSQLite(MainActivity.this);

            String number = NumberPhone_main.getText().toString().trim();
            String  password = Password_main.getText().toString().trim();

            if(number.isEmpty() || password.isEmpty()){
                Toast.makeText(MainActivity.this,"Data is empty",Toast.LENGTH_LONG).show();
            }

            else {
                cursor = dataBaseSQLite.getReadableDatabase().rawQuery("SELECT *FROM " + DataBaseSQLite.TABLENAME + " WHERE "
                        + DataBaseSQLite.DATA_NUMBERPHONE + " =? AND "
                        + DataBaseSQLite.DATA_PASSWORD + " =?", new String[]{number, password});

                if (cursor.getCount() != 0) {
                    if(cursor.moveToFirst()){
                        Intent intent = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(intent);
                    }


                }
            }



        }
    });

    }







}