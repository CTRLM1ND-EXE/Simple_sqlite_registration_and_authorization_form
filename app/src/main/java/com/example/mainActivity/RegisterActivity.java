package com.example.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.simple_sqlite_registration_and_authorization_form.R;

public class RegisterActivity extends AppCompatActivity {


    private Button Button_authorization,Button_Back;
    private EditText editTextRegName,editTextRegSurname,editTextRegNumberPhone,editTextRegPassword;

    public static SQLiteDatabase dataBaseSQLite;
    public static SQLiteOpenHelper openHelper;

    public  static  String NAME_REG,SURNAME_REG,NUMBER_REG,PASSWORD_REG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        init();

        openHelper = new DataBaseSQLite(this);






        Button_authorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 dataBaseSQLite = openHelper.getWritableDatabase();
                 NAME_REG = editTextRegName.getText().toString().trim();
                 SURNAME_REG = editTextRegSurname.getText().toString().trim();
                 NUMBER_REG = editTextRegNumberPhone.getText().toString().trim();
                 PASSWORD_REG = editTextRegPassword.getText().toString().trim();

        if(NAME_REG.isEmpty() || SURNAME_REG.isEmpty() || NUMBER_REG.isEmpty() || PASSWORD_REG.isEmpty()){
            Toast.makeText(RegisterActivity.this,"Data is empty",Toast.LENGTH_LONG).show();
        }
        else{
            dataBaseSQLite = openHelper.getReadableDatabase();
            input(NAME_REG,SURNAME_REG,NUMBER_REG,PASSWORD_REG);
            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
        }









            }
        });

        Button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }





    public  void input (String name,String surname,String number,String password){
        dataBaseSQLite = openHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseSQLite.DATA_NAME,name);
        contentValues.put(DataBaseSQLite.DATA_SURNMAE,surname);
        contentValues.put(DataBaseSQLite.DATA_NUMBERPHONE,number);
        contentValues.put(DataBaseSQLite.DATA_PASSWORD,password);

        long id = dataBaseSQLite.insert(DataBaseSQLite.TABLENAME, null, contentValues);



    }
    public  void  init(){
        Button_authorization = (Button)findViewById(R.id.button_auth);
        Button_Back = (Button)findViewById(R.id.button_back);
        editTextRegName = (EditText)findViewById(R.id.editTextName);
        editTextRegSurname = (EditText)findViewById(R.id.editTextSurname);
        editTextRegNumberPhone = (EditText)findViewById(R.id.editTextNumberPhone);
        editTextRegPassword = (EditText)findViewById(R.id.editTextPassword);
    }

}