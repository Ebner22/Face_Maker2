package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class FaceView extends SurfaceView {
    private Face face=new Face();

    Paint facePaint=new Paint();
    Paint eyePaint=new Paint();
    Paint hairPaint=new Paint();

    private float cen_x=950.0f;
    private float cen_y=320.0f;
    private float height=400.0f;
    private float width=200.0f;
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void OnDraw(Canvas canvas){
        canvas.drawOval(cen_x-width/2,cen_y-height/2,cen_x+width/2,cen_y+height/2,facePaint);
    }
}
