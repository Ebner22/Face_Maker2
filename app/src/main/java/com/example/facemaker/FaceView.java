package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class FaceView extends SurfaceView {
    private Face face=new Face();

    Paint facePaint=new Paint();
    Paint eyePaint=new Paint();
    Paint hairPaint=new Paint();

    private float cen_x=550.0f;
    private float cen_y=500.0f;
    private float height=800.0f;
    private float width=600.0f;
    public FaceView(Context context) {
        super(context);
        setWillNotDraw(false);
        facePaint.setColor(face.skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(face.eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(face.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
    }
    public FaceView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        facePaint.setColor(face.skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(face.eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(face.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
    }
    public FaceView(Context context, AttributeSet attrs,int defStyleAttr){
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        facePaint.setColor(face.skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(face.eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(face.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
    }
    public Face getFace(){
        return face;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        facePaint.setColor(Color.BLUE);
        canvas.drawOval(cen_x-width/2,cen_y-height/2,cen_x+width/2,cen_y+height/2,facePaint);

    }
}
