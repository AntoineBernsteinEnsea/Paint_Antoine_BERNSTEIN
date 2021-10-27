import java.awt.*;

public class Square extends Rectangle {

    public Square(int px, int py, Color c){
        super(px,py,c);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {

        if(heightBB>=widthBB) {super.setBoundingBox(heightBB, heightBB);}

        else {super.setBoundingBox(widthBB,widthBB);}
    }


}

