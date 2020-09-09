package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an Adapter for the hair_spinner that allows user to select hair type
        ArrayList<String> hairList=new ArrayList<String>();
        hairList.add("long");
        hairList.add("short");
        hairList.add("bald");
        ArrayAdapter<String> hairAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,hairList);
        Spinner hairSpinner=findViewById(R.id.hair_spinner);
        hairSpinner.setAdapter(hairAdapter);
        /**
         * External citation:
         *  Date: 8 September 2020
         *  Problem: needed to determine valid inputs for an ArrayAdapter constructor
         *  Resources:
         *      https://developer.android.com/reference/android/widget/ArrayAdapter#ArrayAdapter(android.content.Context,%20int,%20T[])
         *      https://developer.android.com/reference/java/util/List
         *      https://developer.android.com/reference/java/util/ArrayList
         *   Solution: An arraylist can be used
         */
    }
}