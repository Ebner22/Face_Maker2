package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

/**
 * FaceView draws the face object
 * It is created in the XML code
 * @variable face is a reference to the face object that it is drawing
 * @variable facePaint is a Paint object with the color of the skin
 * @variable eyePaint is a Paint object with the color of the eyes
 * @variable hairPaint is a Paint object with the color of the hair
 * @variable whitePaint and blackPaint are Paint objects used to draw white and black (respectively) parts of the face
 * @variable cen_x represents the x-coordinate of the center of the face
 * @variable cen_y represents the y-coordinate of the center of the face
 * @variable height represents the height of the oval of the face
 * @variable width represents the width of the oval of the face
 * @variable eye_width represents the width of the white part of the eyes
 * @variable eye_height represents the height of the white part of the eyes
 * @variable pupil_width represents the diameter of the pupil
 */
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


    /**
     * This constructor calls the constructor for a surfaceView, tells the object to draw itself, and sets up the paint objects
     * @param context is not used
     *
     */
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

    /**
     * This constructor calls the constructor for a surfaceView, tells the object to draw itself, and sets up the paint objects
     * @param context is not used
     * @param attrs is not used
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

    /**
     * This constructor calls the constructor for a surfaceView, tells the object to draw itself, and sets up the paint objects
     * @param context is not used
     * @param attrs is not used
     * @param defStyleAttr is not used
     */
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

    /**
     * This method updates the facepaint objects to have the correct colors so that they continue to match the colors in the face object
     * after the face's colors have been changed.
     */
    public void updateFaceColors(){
        facePaint.setColor(face.skinColor);
        eyePaint.setColor(face.eyeColor);
        hairPaint.setColor(face.hairColor);
        return;
    }
    public Face getFace(){
        return face;
    }

    /**
     * This helper method draws the eyes on the canvas
     * @param canvas is a reference to the canvas object that is displayed on the screen.
     */
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
    /**
     * This helper method draws the hair on the canvas in the appropriate hair style
     * @param canvas is a reference to the canvas object that is displayed on the screen.
     */
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
    /**
     * This helper method draws the nose on the canvas
     * @param canvas is a reference to the canvas object that is displayed on the screen.
     */
    public void drawNose(Canvas canvas){
        float top=cen_y-height/8;
        float bottom=cen_y+height/8;
        canvas.drawLine(cen_x,top, cen_x,bottom,blackPaint);
        float right=cen_x+width/10;

        canvas.drawLine(cen_x,bottom, right, bottom, blackPaint);
        return;
    }
    /**
     * This helper method draws the mouth on the canvas
     * @param canvas is a reference to the canvas object that is displayed on the screen.
     */
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
    /**
     * This method draws is called whenever the view is invalidated and redraws the face
     * @param canvas is a reference to the canvas object that is displayed on the screen.
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas){
        //facePaint.setColor(Color.BLUE);
        drawHair(canvas);
        canvas.drawOval(cen_x-width/2,cen_y-height/2,cen_x+width/2,cen_y+height/2,facePaint);//this is the skin of the face
        drawEyes(canvas);
        drawNose(canvas);
        drawMouth(canvas);

    }
}
