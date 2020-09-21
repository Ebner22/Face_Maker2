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
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.FILL);
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
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        //facePaint.setColor(Color.BLUE);
        drawHair(canvas);
        canvas.drawOval(cen_x-width/2,cen_y-height/2,cen_x+width/2,cen_y+height/2,facePaint);

        drawEyes(canvas);

    }
}
