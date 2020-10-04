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

    Paint whitePaint=new Paint();
    Paint blackPaint=new Paint();

    private float cen_x=550.0f;
    private float cen_y=500.0f;
    private float height=800.0f;
    private float width=600.0f;
    private float eye_width=120.0f;
    private float eye_height=60.0f;
    private float pupil_width=30.0f;


    public FaceView(Context context) {
        super(context);
        setWillNotDraw(false);
        facePaint.setColor(face.skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(face.eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(face.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        blackPaint.setStrokeWidth(2.0f);
    }
    /*
    External Citation
    Date: 10/4/2020
    Issue: I started only overriding the constructor above, but was having issues that confused me. I think a different constructor was being used.
    I wasn't sure which one was being called or if it depending on circumstance.
    Reference: https://developer.android.com/reference/android/view/SurfaceView
    Solution: I overrode three of the four possible constructors for a surfaceView. I have not had issues with the fourth one, so it must not be called (often).
     */
    public FaceView(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        facePaint.setColor(face.skinColor);
        facePaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(face.eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        hairPaint.setColor(face.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        blackPaint.setStrokeWidth(2.0f);
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
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
        blackPaint.setStrokeWidth(2.0f);
    }
    public void updateFaceColors(){
        facePaint.setColor(face.skinColor);
        eyePaint.setColor(face.eyeColor);
        hairPaint.setColor(face.hairColor);
        return;
    }
    public Face getFace(){
        return face;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas canvas){
        float left=cen_x-width*1/5-eye_width/2;
        float top=cen_y-height*1/5-eye_height/2;
        float right= cen_x-width*1/5+eye_width/2;
        float bottom=cen_y-height*1/5+eye_height/2;
        float cx=cen_x-width*1/5;
        float cy=cen_y-height*1/5;
        canvas.drawOval(left, top, right, bottom ,whitePaint);
        canvas.drawCircle(cx,cy,pupil_width/2+10.0f,eyePaint);
        canvas.drawCircle(cx,cy,pupil_width/2,blackPaint);
        left=cen_x+width*1/5-eye_width/2;
        top=cen_y-height*1/5-eye_height/2;
        right= cen_x+width*1/5+eye_width/2;
        bottom=cen_y-height*1/5+eye_height/2;
        cx=cen_x+width*1/5;
        canvas.drawOval(left, top, right, bottom ,whitePaint);
        canvas.drawCircle(cx,cy,pupil_width/2+10.0f,eyePaint);
        canvas.drawCircle(cx,cy,pupil_width/2,blackPaint);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawHair(Canvas canvas){
        if (face.hairStyle==1) {
            float left = cen_x - width / 2;
            float top = cen_y - height / 2 - 20.0f;
            float right = cen_x + width / 2;
            float bottom = cen_y;
            canvas.drawOval(left, top, right, bottom, hairPaint);
        }
        else if (face.hairStyle==0){
            float left = cen_x - width / 2 -25.0f;
            float top = cen_y - height / 2 - 30.0f;
            float right = cen_x + width / 2 + 25.0f;
            float bottom = cen_y + height*4/5;
            canvas.drawOval(left, top, right, bottom, hairPaint);
        }
    }
    public void drawNose(Canvas canvas){
        float top=cen_y-height/8;
        float bottom=cen_y+height/8;
        canvas.drawLine(cen_x,top, cen_x,bottom,blackPaint);
        float right=cen_x+width/10;

        canvas.drawLine(cen_x,bottom, right, bottom, blackPaint);
        return;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawMouth(Canvas canvas){
        float left=cen_x-width/5;
        float top=cen_y+height/5;
        float right=cen_x+width/5;
        float bottom=cen_y+height/8+height/5;

        canvas.drawArc(left, top, right, bottom, 0,180, false, blackPaint);
    }
    /*
        External Citation
        Date: 10/4/2020
        Problem: I wanted a more suitable shape for the mouth.
        Resource: https://developer.android.com/reference/android/graphics/Canvas#drawArc(float,%20float,%20float,%20float,%20float,%20float,%20boolean,%20android.graphics.Paint)
        Solution: I used the arc function.

      */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        //facePaint.setColor(Color.BLUE);
        drawHair(canvas);
        canvas.drawOval(cen_x-width/2,cen_y-height/2,cen_x+width/2,cen_y+height/2,facePaint);
        drawEyes(canvas);
        drawNose(canvas);
        drawMouth(canvas);

    }
}
