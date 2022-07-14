package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class retrieveScreen extends AppCompatActivity {
    EditText namefield, passfield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_screen);
        namefield = (EditText) findViewById(R.id.name_field);
        passfield = (EditText) findViewById(R.id.pass_field);
    }


    public void Retrieve(View view) {
        try {
            FileInputStream fis = openFileInput("androidtext.txt");
            int read = -1;
            StringBuffer buff = new StringBuffer();
            while ((read = fis.read())!=-1){

                buff.append((char) read);

            }

            String name = buff.substring(0, buff.indexOf(""));
            String pass = buff.substring(0, buff.indexOf("")+1);

            namefield.setText(name);
            passfield.setText(pass);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Back(View view) {

    }


}