import android.graphics.Color;

public class Face {
    private long skinColor;
    private long eyeColor;
    private long hairColor;
    private int hairStyle;

    public Face(){
        skinColor=randomize();
        eyeColor=randomize();
        hairColor=randomize();
        hairStyle=1;
    }

    public long randomize(){
        int a=(int)Math.random()*255;
        int r=(int)Math.random()*255;
        int g=(int)Math.random()*255;
        int b=(int)Math.random()*255;
        return Color.argb(a,r,g,b);

    }

}
