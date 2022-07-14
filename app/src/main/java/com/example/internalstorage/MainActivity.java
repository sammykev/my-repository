package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText namefield, passfield;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namefield = (EditText) findViewById(R.id.name_field);
        passfield = (EditText) findViewById(R.id.pass_field);
    }

    public void Save(View view) {
        String name = namefield.getText().toString();
        String pass = passfield.getText().toString();

        File file = null;
        FileOutputStream fos = null;

        try {
        name = name + "";
        file = getFilesDir();


            fos = openFileOutput("androidtext.txt", MODE_PRIVATE);
            fos.write(name.getBytes());
            fos.write(pass.getBytes());

            Toast.makeText(MainActivity.this, "Saved successfully at path \n" +file +"\tandroidtext.txt",Toast.LENGTH_LONG).show();

            namefield.setText("");
            passfield.setText("");
            fos.close();

            return;

        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void Next(View view) {
        Intent intent = new Intent(MainActivity.this, retrieveScreen.class);
        startActivity(intent);
    }
}