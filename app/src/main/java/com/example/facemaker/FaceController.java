package com.example.facemaker;

import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class FaceController implements SeekBar.OnSeekBarChangeListener{
    private Face face;
    private FaceView fView;

    private SeekBar red_slide;
    private SeekBar green_slide;
    private SeekBar blue_slide;

    private RadioButton hair_but;
    private RadioButton eyes_but;
    private RadioButton skin_but;
    private RadioButton rand_face_but;

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

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
