import java.awt.*;

import static java.lang.Math.abs;

public class Square extends Rectangle {

    public Square(int px, int py, Color c){
        super(px,py,c);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {

        if(heightBB>=widthBB) {super.setBoundingBox(heightBB, abs(heightBB)*Integer.signum(widthBB));}

        else {super.setBoundingBox(abs(widthBB)*Integer.signum(heightBB),widthBB);}
    }

    @Override
    public String toString() {
        return "Carré de Couleur = "+ c;
    }
}

