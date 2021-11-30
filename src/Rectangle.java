import java.awt.*;

import static java.lang.Math.abs;

public class Rectangle extends Figure{

    int length = 0 ;
    int width = 0 ;

    public Rectangle(int px, int py, Color c){
        this.c = c;
        p.X = px;
        p.Y = py;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        length = heightBB;
        width = widthBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(p.X+(width-abs(width))/2, p.Y+(length-abs(length))/2, abs(width),abs(length));
    }

    @Override
    public String toString() {
        return " Rectangle de Couleur = "+ c;
    }

}
