import java.awt.*;

import static java.lang.Math.abs;

public class Ellipse extends Figure {

    int SemiAxisX = 0;
    int SemiAxisY = 0;

    public Ellipse(int px, int py, Color c){
        this.c = c;
        p.X = px;
        p.Y = py;
    };

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        SemiAxisX = widthBB;
        SemiAxisY = heightBB;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(p.X+(SemiAxisX-abs(SemiAxisX))/2, p.Y+(SemiAxisY-abs(SemiAxisY))/2,abs(SemiAxisX),abs(SemiAxisY));
    }

    @Override
    public String toString() {
        return "Ellipse de Couleur = "+ c;
    }


}
