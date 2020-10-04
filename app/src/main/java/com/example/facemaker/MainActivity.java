package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
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
        Spinner hairSpinner=findViewById(R.id.hair_spinner);
        hairSpinner.setAdapter(hairAdapter);

        FaceView myFaceView=(FaceView) findViewById(R.id.surfaceView);

        SeekBar red_slide=findViewById(R.id.seekBar_red);
        SeekBar green_slide=findViewById(R.id.seekBar_green);
        SeekBar blue_slide=findViewById(R.id.seekBar_blue);
        RadioButton hair_but=findViewById(R.id.radioButton_hair);
        RadioButton eyes_but=findViewById(R.id.radioButton_eyes);
        RadioButton skin_but=findViewById(R.id.radioButton_skin);
        RadioButton rand_face_but=findViewById(R.id.radioButton_random_face);


        FaceController fCont=new FaceController(myFaceView, red_slide, green_slide, blue_slide, hair_but, eyes_but, skin_but,rand_face_but);

        red_slide.setOnSeekBarChangeListener(fCont);
        green_slide.setOnSeekBarChangeListener(fCont);
        blue_slide.setOnSeekBarChangeListener(fCont);
        hair_but.setOnClickListener(fCont);
        eyes_but.setOnClickListener(fCont);
        skin_but.setOnClickListener(fCont);
        rand_face_but.setOnClickListener(fCont);
        hairSpinner.setOnItemSelectedListener(fCont);

    }
}