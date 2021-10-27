import java.awt.*;

public class Circle extends Ellipse{

    public Circle(int px, int py, Color c){
        super(px, py,c);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {

        if(heightBB>=widthBB) {super.setBoundingBox(heightBB, heightBB);}

        else {super.setBoundingBox(widthBB,widthBB);}
    }


}
