package com.example.facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.util.Log;

public class FaceController implements SeekBar.OnSeekBarChangeListener, RadioButton.OnClickListener, Spinner.OnItemSelectedListener{
    /**
     * This class is the listener for the interactive widgets (the seekbars, radiobuttons, and spinner).
     *
     * @variable face is a reference to the face object displayed on the screen
     * @variable fView is a reference to the faceView that displays the face object
     * @variable red_slide is a reference to the seekbar for the red value
     * @variable green_slide is a reference to the seekbar for the green value
     * @variable blue_slide is a reference to the seekbar for the blue value
     * @variable hair_but is a reference to the radiobutton that, when selected, allows the hair color to be changed
     * @variable eyes_but is a reference to the radiobutton that, when selected, allows the eye color to be changed
     * @variable skin_but is a reference to the radiobutton that, when selected, allows the skin color to be changed
     * @variable rand_face_but is a reference to the radiobutton that, when clicked, randomizes all three colors and the hair style
     * @variable selected indicates what radiobutton is selected, and is used to determine which of the face's colors the seekbars should correspond to
     * @author is Sarah Ebner
     *
     */

    private Face face;
    private FaceView fView;

    private SeekBar red_slide;
    private SeekBar green_slide;
    private SeekBar blue_slide;

    private RadioButton hair_but;
    private RadioButton eyes_but;
    private RadioButton skin_but;
    private RadioButton rand_face_but;


    private int selected=3; //is hair(0), eyes (1), skin (2), or random face (3) selected.

    /**
     * The faceController constructor. Creates a faceController object
     * @param fv is a reference to the faceView object
     * @param red is a reference to the seekbar controlling red
     * @param green is a reference to the seekbar controlling green
     * @param blue is a reference to the seekbar controlling blue
     * @param hair is a reference to the radiobutton, that, when selected, allows the hair color to be changed
     * @param eyes is a reference to the radiobutton, that, when selected, allows the eye color to be changed
     * @param skin is a reference to the radiobutton, that, when selected, allows the skin color to be changed
     * @param rand is a reference to the radiobutton that, when clicked, randomizes all three colors and the hair style
     */
    public FaceController(FaceView fv,SeekBar red, SeekBar green, SeekBar blue, RadioButton hair, RadioButton eyes, RadioButton skin, RadioButton rand){
        fView=fv;
        face=fv.getFace();
        red_slide=red;
        blue_slide=blue;
        green_slide=green;
        hair_but=hair;
        eyes_but=eyes;
        skin_but=skin;
        rand_face_but=rand;


    }

    /**
     * This method updates the color of the hair, eyes, or skin when a slider's progress is  changed.
     * @param seekBar is a reference to the seekbar that sent the event. This parameter is not used.
     * @param i is not used.
     * @param b is not used.
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int r=red_slide.getProgress();
        int g=green_slide.getProgress();
        int blue=blue_slide.getProgress();
        int col=Color.argb(255,r,g,blue);
        if (selected==-1){return;}
        else if (selected==0){face.hairColor=col;}
        else if (selected==1){face.eyeColor=col;}
        else if (selected==2){face.skinColor=col;}
        else if (selected==3){face.randomize();}
        fView.updateFaceColors();
        fView.invalidate();
        return;

    }

    /**
     * This function is not used.
     * @param seekBar is a reference to the seekbar that sent the event. This parameter is not used.
     */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    /**
     * This function is not used.
     * @param seekBar is a reference to the seekbar that sent the event. This parameter is not used.
     */
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    /**
     * This method changes the value of selected, which is used to know if the hair, eye, or skin color should be changed based on the slider inputs
     * @param view is a reference to the button that sent the event.
     */
    @Override
    public void onClick(View view) {
        if (view==hair_but){selected=0; updateSeekbars();}
        else if (view==eyes_but){selected=1; updateSeekbars();}
        else if (view==skin_but){selected=2; updateSeekbars();}
        else if (view==rand_face_but){
            face.randomize();
            selected=3;
            updateSeekbars();
        }
    }

    /**
     * This method updates the seekbars to reflect the color of the hair, eyes, or face
     * It is called when the color the seekbars control changes in response to something other than the user sliding the seekbar
     */
    private void updateSeekbars(){
        if (selected==0){//The radiobutton is set to hair, so the seekbars should match the hair color
            int red=Color.red(face.hairColor);
            int green=Color.green(face.hairColor);
            int blue=Color.blue(face.hairColor);
            red_slide.setProgress(red);
            green_slide.setProgress(green);
            blue_slide.setProgress(blue);
        }
        else if (selected==1){//The radiobutton is set to eyes, so the seekbars should match the eye color
            int red=Color.red(face.eyeColor);
            int green=Color.green(face.eyeColor);
            int blue=Color.blue(face.eyeColor);
            red_slide.setProgress(red);
            green_slide.setProgress(green);
            blue_slide.setProgress(blue);
        }
        else if (selected==2){//The radiobutton is set to skin, so the seekbars should match the skin color
            int red=Color.red(face.skinColor);
            int green=Color.green(face.skinColor);
            int blue=Color.blue(face.skinColor);
            red_slide.setProgress(red);
            green_slide.setProgress(green);
            blue_slide.setProgress(blue);
        }
        else{//the radiobutton is set to random face, so the seekbars aren't representing any color, so they should be at zero
            red_slide.setProgress(0);
            green_slide.setProgress(0);
            blue_slide.setProgress(0);
        }
        /*
        External Citation
        Date: 10/4/2020
        Problem: needed to separate the integer created by Color.rgb back into r, g, and b components
        Resource: https://developer.android.com/reference/android/graphics/Color#red(long)
        Solution: I used the Color.red(), Color.green(), and Color.blue functions

        */
    }

    /**
     * This method responds to an item in the hair spinner being selected. It changes the face's hair style to match the spinner selection.
     * @param adapterView references the arraylist for the spinner. It is not used.
     * @param view references the spinner object. It is not used.
     * @param i is the index of the selected item in the spinner's arrayList. i=0 is long har, i=1 is short hair, i=2 is bald.
     * @param l is not used.
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==0){
            //long hair
            face.hairStyle=0;
        }
        else if (i==1){
            face.hairStyle=1;//short
        }
        else if (i==2){
            face.hairStyle=2;
        }
        else{
            Log.i("Spinner","i is"+i);
        }
        fView.invalidate();
        return;
    }
    /*
        External Citation
        Date: 10/4/2020
        Problem: I needed to know the proper listener for a spinner
        Resource: https://developer.android.com/guide/topics/ui/controls/spinner
        Solution: I used the OnItemSelectedListener interface.

     */

    /**
     * This method is not used.
     * @param adapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
