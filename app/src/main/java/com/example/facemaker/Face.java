package com.example.facemaker;

import android.graphics.Color;

public class Face {
    /**
     * represents a com.example.facemaker.Face
     * @variable skinColor is an integer representing an rgba value created using Color.argb()
     * @variable eyeColor is an integer representing an rgba value created using Color.argb()
     * @variable hairColor is an integer representing an rgba value created using Color.argb()
     * @variable hairStyle is an integer with a value of 0, 1, or 2, representing the hair styles in the hair spinner
     * @author is Sarah Ebner
     *
     */
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;


    public Face(){
        /**
         * creates a face with a random skin, eye, hair color, and hair style
         * @author is Sarah Ebner
         */
        skinColor=randCol();
        eyeColor=randCol();
        hairColor=randCol();
        hairStyle=(int)(Math.random()*3);


    }

    /**
     * This method gives random colors to the skin, eyes, and hair and randomizes the hair style
     */
    public void randomize(){
        skinColor=randCol();
        eyeColor=randCol();
        hairColor=randCol();
        hairStyle=(int)(Math.random()*3);
    }

    public int randCol(){
        /**
         * creates a random color (represented as an integer)
         * @author is Sarah Ebner
         */
        int a=255;
        int r=(int)(Math.random()*255);
        int g=(int)(Math.random()*255);
        int b=(int)(Math.random()*255);
        return Color.argb(a,r,g,b);

    }

}
